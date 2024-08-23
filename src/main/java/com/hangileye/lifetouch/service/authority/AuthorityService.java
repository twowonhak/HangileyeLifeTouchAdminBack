package com.hangileye.lifetouch.service.authority;

import com.hangileye.lifetouch.mapper.ErrorMapper;
import com.hangileye.lifetouch.mapper.authority.AuthorityMapper;
import com.hangileye.lifetouch.model.authority.AuthorityModel;
import com.hangileye.lifetouch.model.common.MenuModel;
import com.hangileye.lifetouch.resultCode.ResponseData;
import com.hangileye.lifetouch.utill.ErrorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AuthorityService extends ErrorHistory {

    private final AuthorityMapper authorityMapper;
    private final ErrorMapper errorMapper;

    public AuthorityService(AuthorityMapper authorityMapper, ErrorMapper errorMapper) {
        this.authorityMapper = authorityMapper;
        this.errorMapper = errorMapper;
    }

    @Transactional
    public ResponseEntity<ResponseData> searchSelect(HttpServletRequest request, AuthorityModel authorityModel) {
        ResponseData res = new ResponseData();
        try {
            Map map = new HashMap<>();
            AuthorityModel model = authorityMapper.searchSelect(authorityModel.getSearchInfo());
            if (model != null) {
                map.put("info", model);
                map.put("use", authorityMapper.useMenuSelect(model.getId()));
                map.put("unUse", authorityMapper.unUseMenuSelect(model.getId()));
            }
            res.setData(map);
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }

    @Transactional
    public ResponseEntity<ResponseData> menuSave(HttpServletRequest request, MenuModel menuModel) {
        ResponseData res = new ResponseData();
        try {
            authorityMapper.useMenuDelete(menuModel.getUserId());
            if(menuModel.getMenuArr().length > 0){
                for (String menu : menuModel.getMenuArr()) {
                    MenuModel model = new MenuModel();
                    model.setUserId(menuModel.getUserId());
                    model.setMenuCd(menu);
                    authorityMapper.useMenuInsert(model);
                }
            }
            res.setSuccess();
            return new ResponseEntity<>(res, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return errorHistory(request, res, errorMapper, e);
        }
    }
}
