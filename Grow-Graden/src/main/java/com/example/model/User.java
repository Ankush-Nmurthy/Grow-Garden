package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "FirstName cannot be null or blank")
	@Size(min = 2, max = 20, message = "Size of the first name should be b/w 3-20 charecter.")
	@Column(nullable = false, length = 30)
	private String firstName;

	@NotBlank(message = "LastName cannot be null or blank")
	@Size(min = 2, max = 20, message = "Size of the first name should be b/w 3-20 charecter.")
	@Column(nullable = false, length = 30)
	private String lastName;

	@NotNull(message = "Please provide email")
	@Email(regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Please provide a valid email")
	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Pattern(regexp = "[6-9][0-9]{9}", message = "please provide 10 digit Indian mobile number")
	@Column(nullable = false, length = 10)
	private String mobileNumber;

	private String role;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime lastModifiedDate;

	@Embedded
	@ElementCollection
	private Set<Address> addresses;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Product> productList;
	
	@Embedded
	@ElementCollection
	@CollectionTable(name = "payment_Information",joinColumns = @JoinColumn(name = "user_id"))
	private List<PaymentInformation> payments = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	private List<Rating> ratings;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	private List<Review> review;
	
//	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planter;
	
	
	/**
	 * {
			"firstName" : "Abcd",
			"lastName" : "hb",
			"email" : "p@p.com",
			"password" : "12345",
			"mobileNumber" : "9909999999",
			"role" : "Customer"
		}
	 */
}
