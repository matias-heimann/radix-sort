package com.company;

import java.util.Arrays;

public class StringUtils {

    public static String[] intArrayToStringArray(int[] arr){
        return Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
    }

    public static void fillWithZeros(int[] arr, String[] arrString){
        int maxLength = 0;
        for(int i = 0; i < arrString.length; i++) {
            if(maxLength < arrString[i].length()) {
                maxLength = arrString[i].length();
            }
        }

        for(int i = 0; i < arrString.length; i++) {
            String format = "%0"+ (maxLength)+"d";
            if(maxLength != arrString[i].length()) {
                arrString[i] = String.format(format, arr[i]);
            }
        }
    }

    public static int[] stringArrayTointArray(String[] arrString){
        return Arrays.stream(arrString).mapToInt(Integer::parseInt).toArray();
    }

}
