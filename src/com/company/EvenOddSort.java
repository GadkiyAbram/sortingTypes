package com.company;

public class EvenOddSort extends StupidSort implements ArraySort {

    private boolean fst;

    public EvenOddSort(int[] userArray) {
        super(userArray);
        fst = false;
    }

    @Override
    public int[] arraySort(int[] array){
        while (fst != true){
            for (int i = 0; i < array.length - 1; i = i + 2){
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            for (int j = 1; j < array.length - 1; j = j + 2){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            for (int k = 0; k < 3; k++){
                if (array[k] < array[k + 1]){
                    fst = true;
                }else {
                    fst = false;
                    break;
                }
            }
        }
        return array;
    }
}
