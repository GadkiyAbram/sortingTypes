package com.company;

public class BubbleSort extends StupidSort implements ArraySort {

    protected int count;

    public BubbleSort(int[] userArray) {
        super(userArray);
        count = userArray.length;
    }

    @Override
    public int[] arraySort(int[] array){
        while (count != 0){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                count--;
            }
        }
        return array;
    }
}
