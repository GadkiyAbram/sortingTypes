package com.company;

import java.util.Scanner;

public class ArtificialIntellect {

    private int randNum;

    public ArtificialIntellect(){
        randNum = (int) (Math.random() * 100 + 1);
        System.out.println("Fine, I set the number, try to guess it");
    }

    public void tryGuessTheNumber(){
        Scanner sc = new Scanner(System.in);
        boolean correct = false;

        while (correct != true){
            int number = sc.nextInt();
            if (number == randNum){
                System.out.println("Correct, that's it");
                correct = true;
            }else if (number > randNum){
                System.out.println("No way, my number is SMALLER");
            }else if (number < randNum){
                System.out.println("No way, my number is GREATER");
            }
        }
    }
}
