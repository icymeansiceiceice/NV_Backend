package com.management.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.entity.Department;


@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    @Query(value = "select * from department where isdelete=0",nativeQuery = true)
    List<Department> getAllDepartment();

}
