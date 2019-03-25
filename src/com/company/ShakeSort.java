package com.company;

public class ShakeSort extends BubbleSort implements ArraySort {

    private int count;

    public ShakeSort(int[] userArray) {
        super(userArray);
        count = userArray.length;
    }

    @Override
    public int[] arraySort(int[] array){
        while (count != 0){
            for (int i = 0; i < array.length - count; i++){
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            count--;
            for (int j = array.length - count; j > 0; j--){
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            count--;
        }
        return array;
    }

}
