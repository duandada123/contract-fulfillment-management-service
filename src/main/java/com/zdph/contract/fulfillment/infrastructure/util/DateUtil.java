package com.zdph.contract.fulfillment.infrastructure.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Author duanchao
 * @Date 2021/12/28 16:48
 **/

public class DateUtil {

    public DateUtil() {
    }

    public static LocalDateTime convertLong2LocalDateTime(Long timeStamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
    }

    public static long convertLoaclDateTime2Long(LocalDateTime dateTime){
        return dateTime.toInstant(ZoneOffset.ofHours(8)).getEpochSecond();
    }

    public static String getTimeString(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    public static Date timestampToDate(String timestamp) {
        Date date = new Date();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
            timestamp = timestamp.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
            date = format.parse(timestamp);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }
        return date;
    }
}
