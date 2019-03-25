package com.company;

public class CombSort extends BubbleSort implements ArraySort {

    private double facDecr = 1.247;
    private int dist;

    public CombSort(int[] userArray) {
        super(userArray);
        dist = (int)(userArray.length / facDecr);
    }

    @Override
    public int[] arraySort(int[] array){
        for (int i = 0; i < array.length - 1; i = i + dist){
            if (array[i] > array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }

            dist = (int)(array.length / facDecr);
        }
        int countBubble = array.length;
        while (countBubble != 0){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            countBubble--;
        }
        return array;
    }
}
