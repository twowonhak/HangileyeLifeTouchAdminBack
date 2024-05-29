package com.hangileye.lifetouch.utill;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Slf4j
public class dataUtil {

    /*
        오늘 날짜 조회
        @param format 날짜포맷 yyyyMMdd HHmmss
        @result String
     */
    public static String getToday(String format){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();

        String result = "";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        result = sdf.format(today);

        return result;
    }

    // 랜덤 숫자
    // 파라미터 1개인 경우 최대값.
    // 파라미터 2개인 경우 최소값, 최대값
    public static long getRandomNumber(long... num){
        long min = 0;
        long max = 0;
        if(num.length == 1){
            min = 0;
            max = num[0];
        }else{
            min = num[0];
            max = num[1];
        }
        return (long)Math.floor(Math.random()*(max-min+1)+min);

    }


    // 랜덤 문자 생성
    public static String getRandomString(int strLength){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = strLength;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


}
