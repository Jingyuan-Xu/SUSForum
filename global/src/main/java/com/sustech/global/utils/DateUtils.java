package com.sustech.global.utils;

import com.sustech.global.entity.GlobalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getStringDate(int year,int month,int day){
        String y = String.valueOf(year);
        String m = String.valueOf(month);
        if(m.length()==1) m = "0" + m;
        String d = String.valueOf(day);
        return y + "-" + m + "-" + d;
    }

    public static GlobalDate getDomainDate(String str){
        String[] strs = str.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        GlobalDate globalDate = new GlobalDate();
        globalDate.setYear(year);
        globalDate.setMonth(month);
        globalDate.setDay(day);
        return globalDate;
    }

    public static String getCurrDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

}
