package com.hangileye.lifetouch.mapper;

import com.hangileye.lifetouch.model.SpecialNoteModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecialNoteMapper {
    /*
     * @Description : 특이사항 목록 조회
     * */
    List<SpecialNoteModel> listSelect();

    /*
     * @Description : 상세 조회
     * */
    SpecialNoteModel detailSelect(SpecialNoteModel specialNoteModel);

    /*
     * @Description : 저장
     * */
    void insert(SpecialNoteModel specialNoteModel);

    /*
     * @Description : 삭제
     * */
    void delete(SpecialNoteModel specialNoteModel);

    /*
     * @Description : 환자 케이스 사용 여부
     * */
    Integer specialNoteUse(String key);
}
