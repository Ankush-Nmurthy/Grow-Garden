package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p " + 
		       "WHERE (:category IS NULL OR p.category.name = :category) " +
		       "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
		       "AND (:minDiscount IS NULL OR p.discountPercent >= :minDiscount) " +
		       "ORDER BY " +
		       "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC, " +
		       "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")
		public List<Product> filterProducts(@Param("category") String category,
		                                    @Param("minPrice") Integer minPrice,
		                                    @Param("maxPrice") Integer maxPrice,
		                                    @Param("minDiscount") Integer minDiscount,
		                                    @Param("sort") String sort);
	
	
	@Query(value = "SELECT * FROM product WHERE product_type = 'plant'" , nativeQuery = true)
	public List<Product> getAllPlant();
	
	@Query(value = "SELECT * FROM product WHERE product_type = 'plant'" , nativeQuery = true)
	public List<Product> getAllSeeds();
	
	@Query(value = "SELECT * FROM product WHERE product_type = :producttype ORDER BY"
			+ " CASE WHEN :sortField1 IS NULL THEN NULL ELSE" + "   CASE WHEN :sortField1 = 'field1' THEN field1 END"
			+ " END :sortDirection1," + " CASE WHEN :sortField2 IS NULL THEN NULL ELSE"
			+ "   CASE WHEN :sortField2 = 'field2' THEN field2 END" + " END :sortDirection2,"
			+ " CASE WHEN :sortField3 IS NULL THEN NULL ELSE" + "   CASE WHEN :sortField3 = 'field3' THEN field3 END"
			+ " END :sortDirection3" + " LIMIT :pageSize OFFSET :offset", nativeQuery = true)
	List<Product> findPlantsWithSortingAndPagination(String producttype,String sortField1, String sortDirection1, String sortField2,
			String sortDirection2, String sortField3, String sortDirection3, int pageSize, int offset);


}
