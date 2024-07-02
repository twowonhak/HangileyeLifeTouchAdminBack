package com.hangileye.lifetouch.mapper.stockMain.asset;

import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetMapper {

    List<AssetModel> mainListSelect();

    List<AssetModel> subListSelect();

    void insert(AssetModel assetModel);

}
