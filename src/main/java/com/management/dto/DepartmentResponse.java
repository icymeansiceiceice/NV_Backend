package com.management.dto;

import lombok.Data;

import java.util.List;

import com.management.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    

    private int id;
    private String name;
    private boolean delete;
    private List<User> users;
}
