package com.company;

public class SegmentTree2D {

    final int size = 84;
    public int[][] t = new int[size][size];

    private void build_Y(int vx, int lx, int rx, int vy, int ly, int ry, int a[][]){
        if (ly == ry){
            if (lx == rx){
                t[vx][vy] = a[lx][ly];
            }else{
                t[vx][vy] = t[2 * vx][vy] + t[2 * vx + 1][vy];
            }
        }else{
            int vmiddleY = ly + (ry - ly) / 2;
            build_Y(vx, lx, rx, 2 * vy, ly, vmiddleY, a);
            build_Y(vx, lx, rx, 2 * vy + 1, vmiddleY + 1, ry, a);
            t[vx][vy] = t[vx][2 * vy] + t[vx][2 * vy + 1];
        }
    }

    public void build_X(int vx, int lx, int rx, int a[][]){
        if (lx != rx){
            int vmiddleX = lx + (rx - lx) / 2;
            build_X(2 * vx, lx, vmiddleX, a);
            build_X(2 * vx + 1, vmiddleX + 1, rx, a);
        }
        build_Y(vx, lx, rx, 1, 0, 3, a);                    //COLUMNS!!!!!
    }

    private int finalQuery(int pos, int start, int end, int x1, int x2, int node, int a[][]){
        if (x2 < start || x1 > end){
            return 0;
        }
        if (x1 <= start && end <= x2){
            return t[node][pos];
        }
        int mid = (start + end) / 2;
        int p1 = finalQuery(2 * pos, start, mid, x1, x2, node, a);
        int p2 = finalQuery(2 * pos + 1, mid + 1, end, x1, x2, node, a);
        return p1 + p2;
    }
    //                  vx          0          2      0       2       0       2
    public int query(int pos, int start, int end, int y1, int y2, int x1, int x2, int a[][]){
        if (y2 < start || end < y1){
            return 0;
        }
        if (y1 <= start && end <= y2) {
            return finalQuery(1, 0,3, x1, x2, pos, a);
        }
        int mid = (start + end) / 2;
        int p1 = query(2 * pos, start, mid, y1, y2, x1, x2, a);
        int p2 = query(2 * pos + 1, mid + 1, end, y1, y2, x1, x2, a);
        return p1 + p2;
    }

}
