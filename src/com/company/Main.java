package com.company;

public class Main {

    public final int tSize = 4 * 100000;

    public static void main(String[] args) {

//        int[] a = { 1, 2, 3 };

//        int[][] a = {   {1, 0, 1, 1},                     //  x5 rows, x4 columns
//                        {0, 1, 0, 0},
//                        {0, 0, 0, 1},
//                        {1, 1, 1, 1}};

//        int[][][] a = {
//                {{0, 1}, {0, 0}, {1, 1}, {0, 0},},
//                {{0, 0}, {1, 0}, {1, 0}, {0, 1},},
//                {{0, 0}, {1, 0}, {0, 1}, {1, 0},},
//                {{1, 0}, {0, 0}, {0, 0}, {0, 0},},
//                                                    };

//        int[][][] a = {
//                {{0, 1, 0, 1}, {0, 0, 0, 1}, {1, 1, 0, 1}, {0, 0, 0, 1},},
//                {{0, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 0, 1},},
//                {{0, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 0, 1}, {1, 0, 0, 1},},
//                {{1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1},},
//        };



//        System.out.println(a.length);
//        System.out.println(a[0].length);
//        System.out.println(a[0][0].length);

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

//        int cols = a.length;                        //columns   = 4
//        int rows = a[0].length;                     //rows      = 5
//        final int fSize = a.length * a[0].length;    //fSize    = 20

//        System.out.println("rows = " + rows + " cols = " + cols + " fSize = " + fSize);

        TreeX2D treeX2D = new TreeX2D();
//
//        treeX2D.build_X(1, 0, 3, a);
//        System.out.println("Sum: " + treeX2D.query(1, 0, 3, 0, 4, 0, 4, a));
//        System.out.println("t[pos][node] = " + treeX2D.t[1][4]);
//        System.out.println("Sum = " + treeX2D.sumX(1, 0, 3, 0, 1, 0, 1, a));

//        for (int i = 3; i < 4; i++){
//            System.out.println("\n");
//            for (int j = 3; j < 4; j++)
//                System.out.print("a[" + i + "][" + j + "] = " + a[i][j] + "   ");
//        }
//        System.out.println();
//        System.out.println("a[1][2] = " + c[2][3]);

//        for (int i = 0; i < 16; i++){
//            System.out.println("\n");
////            System.out.println();
//            for (int j = 0; j < 16; j++){
//                System.out.print(" " + treeX2D.t[i][j] + " ");
//            }
//        }

        SegmentTree2D sg = new SegmentTree2D();
//        sg.build_X(1, 0, 3, a);
//        System.out.println(sg.query(1, 0, 3, 0, 4, 0, 4, a));

        int[][][] a = {
                { {0, 1, 0}, {0, 0, 1}, {1, 0, 1} },
                { {0, 1, 0}, {0, 0, 1}, {1, 0, 1} },
                { {0, 0, 0}, {0, 0, 1}, {1, 0, 1} },
        };

        SegmentTree3D sg3D = new SegmentTree3D();
        System.out.println(a.length + " X " + a[0].length + " X " + a[0][0].length);
        sg3D.build_Z(1, 0, 2, a);
        System.out.println("Sum = " + sg3D.sum_x(1, 0, 2, 0, 3, 0, 3, 0, 3));
    }

//    expect(tree(0, 1)(0, 1)(0, 1)).toBe(0);
//    expect(tree(3, 4)(0, 1)(0, 1)).toBe(1);
//    expect(tree(1, 2)(3, 4)(1, 2)).toBe(1);
//
//    expect(tree(2, 3)(0, 4)(0, 2)).toBe(3);
//    expect(tree(2, 3)(1, 4)(0, 2)).toBe(3);
//    expect(tree(0, 4)(2, 3)(0, 2)).toBe(4);
//
//    expect(tree(0, 4)(0, 4)(0, 2)).toBe(10);

}