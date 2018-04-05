package com.chang.adapter.impl;

import com.chang.dal.dao.UserMapper;
import com.chang.dal.model.User;
import com.chang.dal.model.UserExample;
import com.chang.facade.dto.request.UserRequestDTO;
import com.chang.facade.dto.response.UserResponseDTO;
import com.chang.facade.service.UserService;
import org.springframework.beans.BeanUtils;
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
    private UserMapper userMapper;

    @Override
    public List<UserResponseDTO> selectAll() throws Exception{
        UserExample usersExample=new UserExample();
        List<User> users=userMapper.selectByExample(usersExample);
        List<UserResponseDTO> userResponseDTOS=new ArrayList<>();
        for (User user : users){
            userResponseDTOS.add(new UserResponseDTO(user.getId(),user.getName(),user.getPassword(),user.getRole()));
        }
        return userResponseDTOS;
    }

    @Override
    @Transactional(readOnly = false)
    public void addUser(UserRequestDTO requestDTO) throws Exception {
        if (requestDTO==null){
            throw new Exception("添加用户信息不能为空！");
        }
        User users=new User();
        BeanUtils.copyProperties(requestDTO,users);
        userMapper.insertSelective(users);
    }
    @Override
    public UserResponseDTO selectByName(String name) throws Exception{
        User users=userMapper.selectByUsername(name);
        UserResponseDTO responseDTO=new UserResponseDTO();
        BeanUtils.copyProperties(users,responseDTO);
        return responseDTO;
    }
}
