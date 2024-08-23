package com.hangileye.lifetouch.mapper.authority;

import com.hangileye.lifetouch.model.authority.AuthorityModel;
import com.hangileye.lifetouch.model.common.MenuModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorityMapper {

    AuthorityModel searchSelect(String searchInfo);

    List<MenuModel> useMenuSelect(String searchInfo);

    List<MenuModel> unUseMenuSelect(String searchInfo);

    void useMenuDelete(String userId);

    void useMenuInsert(MenuModel model);
}
