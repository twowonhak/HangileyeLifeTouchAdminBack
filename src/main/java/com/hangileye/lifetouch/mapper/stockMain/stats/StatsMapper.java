package com.hangileye.lifetouch.mapper.stockMain.stats;

import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatsMapper {

    List<AssetModel> subListSelect();

    List<AssetModel> mainListSelect();
}
