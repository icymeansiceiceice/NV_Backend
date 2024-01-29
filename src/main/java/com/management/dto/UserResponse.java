package com.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    
    private int id;
    private int userID;
    private String name;
    private String phone;
    private String email;
    private String password;
    private boolean delete;

}
