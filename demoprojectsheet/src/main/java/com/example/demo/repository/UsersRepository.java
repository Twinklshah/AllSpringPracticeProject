package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	List<Users> findByDepartmentId(Integer departmentId);
}
