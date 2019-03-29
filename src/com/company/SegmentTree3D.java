package com.company;

public class SegmentTree3D {

    final int size = 500;
    public int[][][] t = new int[size][size][size];

    public int sum_z(int vy, int vx, int vz, int l, int r, int lz, int rz){     //z
        if (rz < l || r < lz) { return 0; }
        if (l >= lz && r <= rz){
            return t[vy][vx][vz];
        }
        int midZ =  (l + r) / 2;
        int f = sum_z(vy, vx, 2 * vz, l, midZ, lz, Math.min(midZ, rz));
        int s = sum_z(vy, vx, 2 * vz + 1, midZ + 1, r, Math.max(lz, midZ + 1), rz);
        return f + s;
    }

    public int sum_y(int vy, int vx, int l, int r, int ly, int ry, int lz, int rz){     //y, z
        if (ry < l || r < ly) { return 0; }

        if(l >= ly && r <= ry)
        {
            return sum_z(vx, vy, 1, 0, 2, lz, rz);
        }
        int midY = (l + r) / 2 ;
        int f = sum_y(2 * vy, vx, l, midY, ly, Math.min(midY, ry), lz, rz);
        int s = sum_y(2 * vy + 1, vx, midY + 1, r, Math.max(midY + 1, ly), ry, lz, rz);
        return f + s;
    }

    public int sum_x(int vx, int l, int r, int ly, int ry, int lx, int rx, int lz, int rz){     //y, x, z
        if(lx > rx) {
            System.out.println(lx + " > " + rx);
            return 0;
        }
        if(lx <= l && r <= rx)
        {
            return sum_y(vx, 1,  0, 2, ly, ry, lz, rz);
        }
        int midX = (l + r) / 2;
        System.out.println("midX = " + midX);
        int f = sum_x(2 * vx, l, midX, ly, ry, lx, Math.min(midX, rx), lz, rz);
        System.out.println("f = " + f);
        int s = sum_x(2 * vx  + 1, midX + 1, r, ly, ry, Math.max(midX + 1, lx), rx, lz, rz);
        System.out.println("s = " + s);
        return f + s;
    }

    public void print(){
        System.out.println(this.t);
    }

    private void build_Y(int vy, int ly, int ry, int vx, int lx, int rx, int vz, int lz, int rz, int a[][][]){
        if (ly == ry){
            if (lx == rx && lz == rz){
                t[vy][vx][vz] = a[ly][lx][lz];
            } else if (lx == rx && lz != rz){
                t[vy][vx][vz] = t[vy][vx][2 * vz] + t[vy][vx][2 * vz + 1];
            } else if (lx != rx && lz == rz){
                t[vy][vx][vz] = t[vy][2 * vx][vz] + t[vy][2 * vx + 1][vz];
            }
        }else{
            int vmiddleY = (ly + ry) / 2;
            build_Y(2 * vy, ly, vmiddleY, vx, lx, rx, vz, lz, rz, a);
            build_Y(2 * vy + 1, vmiddleY + 1, ry, vx, lx, rx, vz, lz, rz, a);
            t[vy][vx][vz] = t[2 * vy][vx][vz] + t[2 * vy + 1][vx][vz];
        }
    }

    public void build_X(int vx, int lx, int rx, int vz, int lz, int rz, int a[][][]){
        if (lx != rx){
            int vmiddleX = (lx + rx) / 2;
            build_X(2 * vx, lx, vmiddleX, vz, lz, rz, a);
            build_X(2 * vx + 1, vmiddleX + 1, rx, vz, lz, rz, a);
        }
        build_Y(vx, lx, rx, 1, 0, 2, vz, lz, rz, a);                    //COLUMNS!!!!!
    }

    public void build_Z(int vz, int lz, int rz, int a[][][]){
        if (lz != rz){
            int vmiddleZ = (lz + rz) / 2;
            build_Z(2 * vz, lz, vmiddleZ, a);
            build_Z(2 * vz + 1, vmiddleZ + 1, rz, a);
        }
        build_X(1, 0, 2, vz, lz, rz, a);
    }

//    public int sum_z(int vx, int vy, int vz, int l, int r, int lz, int rz){
////        if (lz > rz){ return 0; }
//        if (rz < l || r < lz) { return 0; }
//        if (l >= lz && r <= rz){
//            System.out.println(l + " >= " + lz + " && " + r + " <= " + rz);
//            System.out.println("t[" + vx + "][" + vy + "][" + vz + "] = " + t[vx][vy][vz]);
//            return t[vx][vy][vz];
//        }
//        int midZ =  (l + r) / 2;
//        int f = sum_z(vx, vy, 2 * vz, l, midZ, lz, rz);
//        System.out.println("f = " + f);
//        int s = sum_z(vx, vy, 2 * vz + 1, midZ + 1, r, lz, rz);
//        System.out.println("s = " + s);
//        return f + s;
//    }
//
//    public int sum_y(int vx, int vy, int l, int r, int ly, int ry, int lz, int rz){
////        if(ly > ry) return 0;
//        if (ry < l || r < ly) { return 0; }
//
//        if(l >= ly && r <= ry)
//        {
//            return sum_z(vx, vy, 1, 0, 2, lz, rz);
//        }
//        int midY = (l + r) / 2 ;
//        int f = sum_y(vx, 2 * vy, l, midY, ly, ry, lz, rz);
//        System.out.println("f = " + f);
//        int s = sum_y(vx, 2 * vy + 1, midY + 1, r, ly, ry, lz, rz);
//        System.out.println("s = " + s);
//        return f + s;
//    }
//
//    public int sum_x(int vx, int l, int r, int lx, int rx, int ly, int ry, int lz, int rz){
//        if(lx > rx) {
//            System.out.println(lx + " > " + rx);
//            return 0;
//        }
////        System.out.println("rx = " + rx + " l = " + l + " r = " + r + " lx = " + lx);
////        System.out.println(rx + " < " + l + " || " + r + " < " + lx);
////        if (rx < l || r < lx) {
////            return 0;
////        }
//
//        if(lx <= l && r <= rx)
//        {
//            return sum_y(vx, 1,  0, 2, ly, ry, lz, rz);
//        }
//        int midX = (l + r) / 2;
//        System.out.println("midX = " + midX);
//        int f = sum_x(2 * vx, l, midX, lx, rx, ly, ry, lz, rz);
//        System.out.println("f = " + f);
//        int s = sum_x(2 * vx  + 1, midX + 1, r, lx, rx, ly, ry, lz, rz);
//        System.out.println("s = " + s);
//        return f + s;
//    }

}
