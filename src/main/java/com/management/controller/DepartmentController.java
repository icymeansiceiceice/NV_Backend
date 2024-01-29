package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.dto.ApiResponse;
import com.management.entity.Department;
import com.management.entity.User;
import com.management.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createDepartment(@RequestBody Department department) {
        if(departmentService.validate(department)){
            departmentService.createDepartment(department);
            return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(false).message("unsuccessful").build(),HttpStatus.CONFLICT);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateDepartment(@RequestBody Department department) {
        if(departmentService.validate(department)){
            departmentService.updateDepartment(department);
            return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(false).message("unsuccessful").build(),HttpStatus.CONFLICT);
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(),HttpStatus.OK);
    }

    @GetMapping("/getDepartment/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        return new ResponseEntity<Department>(departmentService.getDepartmentbyId(id),HttpStatus.OK);
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<ApiResponse> postMethodName(@RequestBody User user) {
        departmentService.addMemeber(user);
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable("id") int id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).message("successful").build(),HttpStatus.OK);
    }


}
