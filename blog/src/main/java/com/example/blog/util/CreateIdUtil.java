package com.example.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateIdUtil {
    private CreateIdUtil(){}
    private static int getIntNum(final int min,final int max){
        Random random=new Random();
        int num=Math.abs(random.nextInt());
        return num%(max-min+1)+min;
    }

    public static String getId(){
        int num=getIntNum(100,1000);
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String sd=simpleDateFormat.format(d);
         return  "Art"+sd+num;
    }

    public static String getAcId(String str){
        int num=getIntNum(100,1000);
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String sd=simpleDateFormat.format(d);
        return  str+sd+num;
    }

}
