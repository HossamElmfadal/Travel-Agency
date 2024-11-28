package com.example.userservice.dto;


import com.example.userservice.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private User.Role role;
    private boolean enabled = true;
    public enum Role {
        ADMIN, USER
    }
}
