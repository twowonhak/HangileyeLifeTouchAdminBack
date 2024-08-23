package com.hangileye.lifetouch.mapper.questionMain;

import com.hangileye.lifetouch.model.questionMain.ExampleModel;
import com.hangileye.lifetouch.model.questionMain.QueResultModel;
import com.hangileye.lifetouch.model.questionMain.QuestionModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface QueResultMapper {

    List<QuestionModel> commonQuestionSelect();

    List<QuestionModel> questionSelect(QueResultModel queModel);

    List<ExampleModel> exampleSelect(String key);

    List<QuestionModel> lastQuestionSelect();
}
