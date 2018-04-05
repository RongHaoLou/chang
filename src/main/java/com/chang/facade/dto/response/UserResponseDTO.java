package com.chang.facade.dto.response;

/**
 * @author 常培兵
 * @Description: 描述
 * @date 2018/3/22 11:12
 */
public class UserResponseDTO {
    private Integer id;
    private String name;
    private String password;
    private String role;

    public UserResponseDTO(Integer id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public UserResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

