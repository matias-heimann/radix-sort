package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort {


    public static int[] radixSort(int[] arr) {
        String arrString[] = StringUtils.intArrayToStringArray(arr);
        StringUtils.fillWithZeros(arr, arrString);
        for(int i = 0; i < arrString[0].length(); i++) {
            sortByIndex(arrString, i);
            System.out.print("Order by digit " + i + ": ");
            Arrays.stream(arrString).forEach(w -> System.out.print(w + " "));
            System.out.println("");
        }
        arr = StringUtils.stringArrayTointArray(arrString);
        return arr;
    }

    public static void sortByIndex(String[] arrString, int i){
        LinkedList<String> listOfLists[] = new LinkedList[10];
        for(int j = 0; j < arrString.length; j++) {
            int pos = arrString[j].charAt(arrString[0].length() - 1 - i) - '0';
            if(listOfLists[pos] == null) {
                listOfLists[pos] = new LinkedList<>();
            }
            listOfLists[pos].addLast(arrString[j]);
        }
        int count = 0;
        for(int k = 0; k < listOfLists.length; k++) {
            if(listOfLists[k] != null) {
                for (String s : listOfLists[k]) {
                    arrString[count] = s;
                    count++;

                }
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {16233, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        arr = radixSort(arr);
        System.out.print("Final order: ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

    }
}