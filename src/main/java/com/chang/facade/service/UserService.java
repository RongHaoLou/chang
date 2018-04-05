package com.chang.facade.service;

import com.chang.facade.dto.request.UserRequestDTO;
import com.chang.facade.dto.response.UserResponseDTO;

import java.util.List;

/**
 * @author 常培兵
 * @Description: 描述
 * @date 2018/3/22 11:14
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserResponseDTO> selectAll()throws Exception;

    void addUser(UserRequestDTO requestDTO)throws Exception;

    UserResponseDTO selectByName(String name) throws Exception;
}
