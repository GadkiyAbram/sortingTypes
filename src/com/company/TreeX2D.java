package com.company;

public class TreeX2D {

    final int size = 84;
    private int fun(int a, int b){ return a * b; }
    public int[][] t = new int[size][size];

    private void build_Y(int vx, int lx, int rx, int vy, int ly, int ry, int a[][]){
        if (ly == ry){
            if (lx == rx){
//                System.out.println("lx = " + lx + " ly = " + ly);
                t[vx][vy] = a[lx][ly];
//                System.out.println("t[" + vx + "][" + vy + "] = " + t[vx][vy]);
            }else{
                t[vx][vy] = t[2 * vx][vy] + t[2 * vx + 1][vy];
//                System.out.println("t[" + vx + "][" + vy + "] = " + t[vx][vy]);
            }
        }else{
            int vmiddleY = ly + (ry - ly) / 2;
//            int vmiddleY = (ly + ry) / 2;
//            System.out.println("vmiddleY = " + vmiddleY);
            build_Y(vx, lx, rx, 2 * vy, ly, vmiddleY, a);
            build_Y(vx, lx, rx, 2 * vy + 1, vmiddleY + 1, ry, a);
            t[vx][vy] = t[vx][2 * vy] + t[vx][2 * vy + 1];
//            System.out.println("t[" + vx + "][" + vy + "] = " + t[vx][vy]);
        }
    }

    public void build_X(int vx, int lx, int rx, int a[][]){
        if (lx != rx){
//            System.out.println("lx != rx: " + (lx != rx));
//            int vmiddleX = lx + (rx - lx) / 2;
//            int vmiddleX = (lx + rx) / 2;
            int vmiddleX = lx + (rx - lx) / 2;
//            System.out.println("vmiddleX = " + vmiddleX);
            build_X(2 * vx, lx, vmiddleX, a);
            build_X(2 * vx + 1, vmiddleX + 1, rx, a);
        }
        build_Y(vx, lx, rx, 1, 0, 3, a);                    //COLUMNS!!!!!
    }

    private int finalQuery(int pos, int start, int end, int x1, int x2, int node, int a[][]){
        if (x2 < start || end < x1){
            return 0;
        }
        if (x1 <= start && end <= x2){
            System.out.println("x1 = " + x1 + " start = " + start + " end = " + end + " x2 = " + x2);
            System.out.println("pos = " + pos + " node = " + node);
            System.out.println(x1 + " <= " + start + " $$ " + end + " <= " + x2);
            System.out.println("t[" + pos + "][" + node + "] = " + t[pos][node]);
            return t[pos][node];
        }
//        int mid = (start + end) / 2;
        int mid = start + (end - start) / 2;
        int p1 = finalQuery(pos, start, mid, x1, x2, 2 * node, a);
        int p2 = finalQuery(pos, mid + 1, end, x1, x2, 2 * node + 1, a);
//        System.out.println("p1 + p2 = " + (p1 + p2));
        return p1 + p2;
    }

    public int query(int pos, int start, int end, int x1, int x2, int y1, int y2, int a[][]){
        if (y2 < start || end < y1){
            return 0;
        }
        if (y1 <= start && end <= y2){
            System.out.println("Redirected to finalQuery, x1 = " + x1 + ", x2 = " + x2 + ", pos = " + pos);
            return finalQuery(1, 0, 3, x1, x2, pos, a);
        }
//        int mid = (start + end) / 2;
        int mid = start + (end - start) / 2;
        int p1 = query(2 * pos, start, mid, x1, x2, y1, y2, a);
        int p2 = query(2 * pos + 1, mid + 1, end, x1, x2, y1, y2, a);
        System.out.println("p1 + p2 = " + (p1 + p2));
        return p1 + p2;
    }

//    private int sumY(int vx, int vy, int tly, int try_, int ly, int ry, int a[][]){
//        if (ly > ry){
//            return 0;
//        }
//        if (ly >= tly && try_ >= ry){
//            return t[vx][vy];
//        }
//        int tmiddleY = (tly + try_) / 2;
//        System.out.println("vmiddle = " + tmiddleY);
//        int p1 = sumY(vx, 2 * vy, tly, tmiddleY, ly, ry, a);
//        int p2 = sumY(vx, 2 * vy + 1, tmiddleY + 1, try_, ly, ry, a);
//        return p1 + p2;
//    }
//
//    public int sumX(int vx, int tlx, int trx, int lx, int rx, int ly, int ry, int a[][]){
//        if (lx > rx){
//            return 0;
//        }
//        if (lx == tlx && trx == rx){
//            return sumY(vx, 1, 0, 3, ly, ry, a);
//        }
//        int tmiddleX = (tlx + trx) / 2;
//        int p1 = sumX(2 * vx, tlx, tmiddleX, lx, rx, ly, ry, a);
//        int p2 = sumX(2 * vx + 1, tmiddleX + 1, trx, lx, rx, ly, ry, a);
//        return p1 + p2;
//    }


//    public void build(int v, int vl, int vr, int a[]){







//        if (vl == vr) {
//            t[v] = a[vl];
//            return;
//        }
//        int vm = vl + (vr - vl) / 2;
//
//        build(2 * v, vl, vm, a);
//        build(2 * v + 1, vm + 1, vr, a);
//
//        t[v] = fun(t[2 * v], t[2 * v + 1]);
//    }

//    public int query(int v, int vl, int vr, int from, int to, int N){
//
//        if (to < vl || vr < from){
//            return N;
//        }
//
//        if (from <= vl && vr <= to) {
//            return t[v];
//        }
//
//        int vm = vl + (vr - vl) / 2;
//        int ql = query(2 * v, vl, vm, from, to, N);
//        int qr = query(2 * v + 1, vm + 1, vr, from, to, N);
//        return fun(ql, qr);
//    }
}
