package com.ggk.sixt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggk.sixt.vo.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
}
