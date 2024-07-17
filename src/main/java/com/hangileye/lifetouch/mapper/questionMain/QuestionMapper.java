package com.hangileye.lifetouch.mapper.questionMain;

import com.hangileye.lifetouch.model.questionMain.QuestionModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<QuestionModel> listSelect(String useYn);

    QuestionModel detailSelect(String key);

    void insert(QuestionModel questionModel);

    void delete(QuestionModel questionModel);

    void update(QuestionModel questionModel);
}
