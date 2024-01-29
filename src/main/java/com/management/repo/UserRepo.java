package com.management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    
    @Query(value = "select * from user where (userid = ?1 or name =?1 or email=?1) and password = ?2 and isdelete=0",nativeQuery=true)
    User login(String name,String password);

    @Query(value = "select * from user where isdelete=0",nativeQuery=true)
    List<User> getAllUser();

}
