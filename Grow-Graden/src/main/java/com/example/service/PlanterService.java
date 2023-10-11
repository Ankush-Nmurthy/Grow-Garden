package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.dto.PlanterDTO;
import com.example.model.Planter;

public interface PlanterService {

	/**
	 * addPlanter(Planter planter) method adds only planter to DataBase.
	 * 
	 * @param planter
	 * @return Planter
	 */
	Planter addPlanter(Planter planter);

	/**
	 * updatePlanter(PlanterDTO planter) method will Update existing Planter
	 * 
	 * @param planter
	 * @return Planter
	 */
	Planter updatePlanter(PlanterDTO planter);

	/**
	 * deletePlanter(Integer planterId) method Deletes The Planter
	 * 
	 * @param planter
	 * @return String
	 */
	String deletePlanter(Integer planterId);

	/**
	 * viewPlanterById(Integer planterId) method will Planter by planteId
	 * 
	 * @param planterId
	 * @return Planter
	 */
	Planter viewPlanterById(Integer planterId);

	/**
	 * viewAllPlanter(Integer pageno, Integer Size,Map<String,String> sortmap)
	 * method will return all the Planter by using the page and sorting using
	 * multiple values.
	 * 
	 * @param pageno
	 * @param Size
	 * @param sortmap
	 * @return
	 */
	List<Planter> viewAllPlanter(Integer pageno, Integer Size, Map<String, String> sortmap);

	/**
	 * viewPlanterByPlanterShape(String shape) method will View Planter By Planter Shape
	 * 
	 * @param shape
	 * @return List<Planter>
	 */
	List<Planter> viewPlanterByPlanterShape(String shape);

	/**
	 * This method will view All Planters between provided Range
	 * 
	 * @param min
	 * @param max
	 * @return List<Planter>
	 */
	List<Planter> viewAllPlantersbetweenRange(double min, double max);
}
