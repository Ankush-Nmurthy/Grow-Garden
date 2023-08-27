package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.dto.PlanterDto;
import com.example.model.Cart;
import com.example.model.Planter;

public interface PlanterServiceInterface {

	/**
	 * This method add the Planter
	 * 
	 * @param userId
	 * @param planter
	 * @return Planter
	 */
	Cart addPlanter(Integer userId, Integer planterId, Integer quantity);
	
	
	/**
	 * This method adds only planter to DataBase.
	 * @param planter
	 * @return Planter
	 */
	Planter addPlanter(Planter planter);

	/**
	 * This method will Update existing Planter
	 * 
	 * @param planter
	 * @return Planter
	 */
	Planter updatePlanter(PlanterDto planter);

	/**
	 * This method Deletes The Planter
	 * 
	 * @param planter
	 * @return String
	 */
	String deletePlanter(Integer planterId);

	/**
	 * This method will Planter by planteId
	 * 
	 * @param planterId
	 * @return Planter
	 */
	Planter viewPlanterById(Integer planterId);
	

	/**
	 * This method will return all the Planter by using the page and sorting using multiple values.
	 * @param pageno
	 * @param Size
	 * @param sortmap
	 * @return
	 */
	List<Planter> viewAllPlanter(Integer pageno, Integer Size,Map<String,String> sortmap);
	
	
	/**
	 * This method will View Planter By Planter Shape
	 * 
	 * @param shape
	 * @return List<Planter>
	 */
	List<Planter> ViewPlanterByPlanterShape(String shape);

	
	
	/**
	 * This method will view All Planters between provided Range
	 * 
	 * @param min
	 * @param max
	 * @return List<Planter>
	 */
	List<Planter> viewAllPlantersbetweenRange(double min, double max);
}
