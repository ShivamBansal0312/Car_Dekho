package com.cts.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cts.model.CarDetails;
import com.cts.repository.CarRepository;

@Service
@Transactional
public class CarService implements ICarService
{
    
	@Autowired
	CarRepository carRepository;
	
	public List<CarDetails> getAllCar(){
		return (List<CarDetails>) carRepository.findAll();
	}
	
	public void saveCars(CarDetails car) {
		carRepository.save(car);
	}
	
	//to update the detail using its id
		@Override
		public String updatecar(Long carId, CarDetails car) {
			// TODO Auto-generated method stub
//			if(carRepository.findById(carId).isPresent()) {
//				
				CarDetails existingCar = carRepository.findById(carId).get();
				existingCar.setUserId(car.getUserId());
				existingCar.setSeaterType(car.getSeaterType());
				existingCar.setCarNumber(car.getCarNumber());
				existingCar.setYearOfPurchase(car.getYearOfPurchase());
				existingCar.setDistanceTravelled(car.getDistanceTravelled());
				existingCar.setAmount(car.getAmount());
				existingCar.setCarType(car.getCarType());
				existingCar.setBrand(car.getBrand());
				
				CarDetails updatedcar = carRepository.save(existingCar);
				return "Car Model with id "+carId+" is updated";
//			}
//			
//			else {
//				throw new CarNotFoundException("Car ID : "+carId+" Not Found");
//				
//			}
			
		}
		
		
		//to delete the detail using its id 
		@Override
		public String deletecar(Long carId) {
			// TODO Auto-generated method stub
//			if(carRepository.findById(carId).isPresent()) {
				carRepository.deleteById(carId);
				
				return "Car Model id with "+carId+" is deleted";
//			}
//			
//			else {
//				throw new CarNotFoundException("Car Model ID : "+carId+" Not Found");
//				
//			}		
		}
		
		public CarDetails findById(Long carId) {
			
//			if(carRepository.findById(carId).isPresent()) {
				return carRepository.findById(carId).get();
//			}
//			else {
//				throw new CarNotFoundException("Car Model ID : "+carId+" Not Found");
//			}
		}
		
}