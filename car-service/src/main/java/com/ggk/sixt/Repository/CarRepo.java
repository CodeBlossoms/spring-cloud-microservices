package com.ggk.sixt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggk.sixt.vo.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer>{
	
}
