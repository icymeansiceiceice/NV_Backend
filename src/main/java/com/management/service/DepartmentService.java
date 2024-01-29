package com.management.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Department;
import com.management.entity.User;
import com.management.repo.DepartmentRepo;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private UserService userService;


    public void createDepartment(Department department){
        departmentRepo.save(department);
    }

    public void updateDepartment(Department department){
        departmentRepo.save(department);
    }

    public void deleteDepartment(int id){
        Department department = getDepartmentbyId(id);
        department.setDelete(true);
        departmentRepo.save(department);
    }

    public Department getDepartmentbyId(int id){
        return departmentRepo.findById(id).get();
    }

    public List<Department> getDepartments(){
        return departmentRepo.getAllDepartment();
   
    }

    public void addMemeber(User addMember){
        User user = userService.getUserById(addMember.getId());
        user.setDepartment(getDepartmentbyId(addMember.getDepartment().getId()));
        userService.updateUser(user);
    }

    public boolean validate(Department department){
        if(Objects.nonNull(department.getName())){
            return true;
        }
        return false;
    }

}
