package com.company;

public class TreeX1D {

    final int size = 24;

    public int[] t = new int[size];

    private final int N = 1;

    private int fun(int a, int b){ return a * b; }


    public void build(int v, int vl, int vr, int a[]){

        if (vl == vr) {
            t[v] = a[vl];
            return;
        }
        int vm = vl + (vr - vl) / 2;

        build(2 * v, vl, vm, a);
        build(2 * v + 1, vm + 1, vr, a);

        t[v] = fun(t[2 * v], t[2 * v + 1]);
        System.out.print(t[v] + " ");
    }

    public int query(int v, int vl, int vr, int from, int to, int N){

//        if (to < from){
        if (to < vl || vr < from){
//            System.out.println(to + " < " + vl + " " + vr + " < " + from);
//            System.out.println("Recieved 1");
            return N;                                       //return N!!!
        }

        if (from <= vl && vr <= to) {
//            System.out.println("vl = " + vl + ", from = " + from + " vr = " + vr + " to = " + to );
//            System.out.println("returning t[" + v + "] = " + t[v]);
            return t[v];
        }

        int vm = vl + (vr - vl) / 2;
//        System.out.println("vm = " + vm);
        int ql = query(2 * v, vl, vm, from, to, N);
//        System.out.println("ql = " + ql);
        int qr = query(2 * v + 1, vm + 1, vr, from, to, N);
//        System.out.println("sr = " + qr);
        return fun(ql, qr);
    }
}

//    int[] a = { 2, 7, 6, 4, 1, 3 };
//
//    TreeX1D treeX1D = new TreeX1D();
//
//        treeX1D.build(1, 0, a.length - 1, a);
//                System.out.println();
//                for (int e : treeX1D.t){
//                System.out.print(e + " ");
//                }
//                System.out.println();
//
//                int from = 1;
//                int to = 3;
//                System.out.println(treeX1D.query(1, 0, a.length - 1, from, to - 1, 1));
