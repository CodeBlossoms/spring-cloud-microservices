package com.ggk.sixt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ggk.sixt.vo.CarOrder;

@Repository
public interface OrdersRepo extends JpaRepository<CarOrder, Integer>{

	@Query("select co from CarOrder co where co.userId = :userId and co.carRentApproved = 1")
	public List<CarOrder> findOrdersByUser(@Param("userId") int userId);
	
}
