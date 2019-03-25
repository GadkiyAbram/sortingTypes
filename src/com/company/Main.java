package com.company;

public class Main {

    public final int tSize = 4 * 100000;

    public static void main(String[] args) {

//        int[] a = { 1, 2, 3 };

        int[][] a = {   {1, 0, 1, 1},                     //  x5 rows, x4 columns
                        {0, 1, 0, 0},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}};

        char[][] c = {   {'a', 'b', 'c', 'd'},                     //  x5 rows, x4 columns
                        {'e', 'f', 'g', 'l'},
                        {'k', 'n', 'm', 'o'},
                        {'p', 'r', 's', 't'}};

//        int[][] a = {   { 1, 1, 1, 1 },                     //  x5 rows, x4 columns
//                        { 1, 1, 1, 1 },
//                        { 0, 1, 0, 1 },
//                        { 1, 1, 1, 1 }  };
//
//          [1, 0, 1, 1],
//          [0, 1, 0, 0],
//          [0, 0, 0, 1],
//          [1, 1, 1, 1]


        int fromX = 0;
        int toX = 1;
        int fromY = 0;
        int toY = 1;

        int cols = a.length;                        //columns   = 4
//        int rows = a[0].length;                     //rows      = 5
//        final int fSize = a.length * a[0].length;    //fSize    = 20

//        System.out.println("rows = " + rows + " cols = " + cols + " fSize = " + fSize);

        TreeX2D treeX2D = new TreeX2D();

        treeX2D.build_X(1, 0, 3, a);
        System.out.println("Sum: " + treeX2D.query(1, 0, 3, 2, 3, 2, 3, a));
//        System.out.println("t[pos][node] = " + treeX2D.t[1][4]);
//        System.out.println("Sum = " + treeX2D.sumX(1, 0, 3, 0, 1, 0, 1, a));

        for (int i = 3; i < 4; i++){
            System.out.println("\n");
            for (int j = 3; j < 4; j++)
                System.out.print("a[" + i + "][" + j + "] = " + a[i][j] + "   ");
        }
//        System.out.println();
//        System.out.println("a[1][2] = " + c[2][3]);

//        for (int i = 0; i < 16; i++){
//            System.out.println("\n");
////            System.out.println();
//            for (int j = 0; j < 16; j++){
//                System.out.print(" " + treeX2D.t[i][j] + " ");
//            }
//        }
    }


//    expect(tree(0, 1)(0, 1)).toBe(1);
//    expect(tree(0, 1)(1, 2)).toBe(0);
//    expect(tree(3, 4)(3, 4)).toBe(1);
//    expect(tree(2, 3)(2, 3)).toBe(0);
//
//    expect(tree(0, 4)(0, 1)).toBe(2);
//    expect(tree(0, 4)(3, 4)).toBe(3);
//    expect(tree(1, 2)(0, 4)).toBe(1);
//    expect(tree(3, 4)(0, 4)).toBe(4);
//
//    expect(tree(0, 4)(0, 4)).toBe(9);
}