package com.iworkcloud.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Str2Date {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm";

    public static long getTimeByStr(String dateStr, String format){
        DateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
           return simpleDateFormat.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getTimeByStr(String dateStr){
        DateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            return simpleDateFormat.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getDateByStr(String dateStr){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return  0;
        }
    }
}
