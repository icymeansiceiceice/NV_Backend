package com.management.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.User;
import com.management.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DepartmentService departmentService;


    public void createUser(User user){
        userRepo.save(user);
    }

    public void updateUser(User updatedUser){
        updatedUser.setDepartment(departmentService.getDepartmentbyId(updatedUser.getDepartment().getId()));
        userRepo.save(updatedUser);
    }

    public void deleteUser(int userId){
        User user = userRepo.findById(userId).get();
        user.setDelete(true);
        userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.getAllUser();
    }

    public User getUserById(int id){
        User authUser = userRepo.findById(id).get();
        return authUser;
    }

    public User loginUser(User user){
       User authUser = userRepo.login(user.getName(), user.getPassword());
        return authUser;
    }

    public boolean validate(User User){
            if(Objects.nonNull(User.getUserID()) && Objects.nonNull(User.getName()) && Objects.nonNull(User.getEmail()) && Objects.nonNull(User.getPassword()) && Objects.nonNull(User.getPassword())){
                return true;
            }
        return false;
    }

    public boolean loginValidation(User User){
        if(Objects.nonNull(User.getName()) && Objects.nonNull(User.getPassword())){
            return true;
        }
    return false;
    }


}
