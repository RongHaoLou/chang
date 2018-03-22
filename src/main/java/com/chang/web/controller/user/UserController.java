package com.chang.web.controller.user;

import com.chang.facade.dto.ResponseDTOWrapper;
import com.chang.facade.service.UserService;
import com.chang.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseDTOWrapper search() throws Exception {
        return createResponse(userService.selectAll());
    }

}
