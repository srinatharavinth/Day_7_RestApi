package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

	@Query(value = "select * from car where owners = :o",nativeQuery = true)
	public List<Car> getCarOwners(@Param("o") int owners);

	@Query(value = "select * from car where address = :a", nativeQuery = true)
	public List<Car> getCarAddress(@Param("a") String address);

	@Query(value = "select * from car where car_name = :cn", nativeQuery = true)
	public List<Car> getCarName(@Param("cn") String carname);

	@Query(value = "select * from car where owners = :o and car_type = :ct", nativeQuery = true)
	public List<Car> getCarOwnerAndCartype(@Param("o") int owners, @Param("ct") String cartype);
}