package com.company;

public class StupidSort implements ArraySort {

    private int[] arrayToSort;
    protected int count = 0;

    public StupidSort(int[] userArray){
        arrayToSort = userArray;
    }

    @Override
    public int[] arraySort(int[] array){
        while (count != array.length){
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    count = 0;
                }
                count++;
            }
        }
        return array;
    }
}
