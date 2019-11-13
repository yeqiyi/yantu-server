package com.eightrookies.yantu;

public class RandomCodeUtil {
    public static String getRandomNumber(int length){
        String res="";
        for(int i=0;i<length;i++){
            res=res+(int)(Math.random()*9.0D);
        }
        return res;
    }
}
