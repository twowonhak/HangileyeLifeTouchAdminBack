package com.hangileye.lifetouch.mapper.stockMain.stock;

import com.hangileye.lifetouch.model.stockMain.asset.AssetModel;
import com.hangileye.lifetouch.model.stockMain.stock.CodeModel;
import com.hangileye.lifetouch.model.stockMain.stock.StockModel;
import com.hangileye.lifetouch.model.stockMain.stock.TeamModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {

    List<StockModel> listSelect(StockModel stockModel);

    void insert(StockModel stockModel);

    void firstInsert(StockModel stockModel);

    StockModel detailSelect(String id);

    void update(StockModel stockModel);

    void delete(StockModel stockModel);

    void clear(StockModel stockModel);

    void use(StockModel stockModel);

    List<TeamModel> teamListSelect();

    List<AssetModel> assetListSelect();

    List<CodeModel> codeListSelect();

}
