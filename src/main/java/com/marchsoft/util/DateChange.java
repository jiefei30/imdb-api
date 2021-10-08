package com.marchsoft.util;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateChange {
    public long dateToLong(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        return date.getTime();
    }
    public String LongToDate(long timeStamp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 时间戳转换成时间
       return sdf.format(new Date(timeStamp));
    }
}
