package com.stussy.stussyclone20220929wonil.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private int id;
    private String role;
    private String role_name;
}