package com.chang.web.controller.user;

import com.chang.facade.dto.ResponseDTOWrapper;
import com.chang.facade.dto.request.UserRequestDTO;
import com.chang.facade.service.UserService;
import com.chang.web.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 常培兵
 * @Description: User控制器
 * @date 2018/3/22 11:06
 */
@RestController
@RequestMapping("user")
public class UserController  extends BaseController{

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户信息", response = ResponseDTOWrapper.class, notes = "查询所有用户信息")
    @GetMapping
    public ResponseDTOWrapper search() throws Exception {
        return createResponse(userService.selectAll());
    }
    @ApiOperation(value = "添加用户信息", response = ResponseDTOWrapper.class, notes = "添加用户信息")
    @GetMapping
    public ResponseDTOWrapper addUser(@RequestBody @Valid UserRequestDTO requestDTO) throws Exception {
        //BeanUtils.copyProperties(被复制,复制 );
        userService.addUser(requestDTO);
        return  null;
    }

}
