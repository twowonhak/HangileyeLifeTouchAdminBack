package com.hangileye.lifetouch.controller.authority;

import com.hangileye.lifetouch.model.authority.AuthorityModel;
import com.hangileye.lifetouch.model.common.MenuModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.service.authority.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@ResponseBody
@RequestMapping("/api/authority/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @RequestMapping("/searchSelectApi")
    public ResponseData searchSelect(HttpServletRequest request, @RequestBody AuthorityModel authorityModel) {
        return authorityService.searchSelect(request, authorityModel).getBody();
    }

    @RequestMapping("/menuSaveApi")
    public ResponseData menuSave(HttpServletRequest request, @RequestBody MenuModel menuModel) {
        return authorityService.menuSave(request, menuModel).getBody();
    }

}
