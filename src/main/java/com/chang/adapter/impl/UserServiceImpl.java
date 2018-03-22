package com.chang.adapter.impl;

import com.chang.dal.dao.UsersMapper;
import com.chang.dal.model.Users;
import com.chang.dal.model.UsersExample;
import com.chang.facade.dto.response.UserResponseDTO;
import com.chang.facade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 常培兵
 * @Description: 描述
 * @date 2018/3/22 11:20
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<UserResponseDTO> selectAll() throws Exception{
        UsersExample usersExample=new UsersExample();
        List<Users> users=usersMapper.selectByExample(usersExample);
        List<UserResponseDTO> userResponseDTOS=new ArrayList<>();
        for (Users user : users){
            userResponseDTOS.add(new UserResponseDTO(user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getPhone()));
            throw new Exception("抛出异常！");
        }

        return userResponseDTOS;
    }
}
