package com.mycompany.testform;

import java.util.ArrayList;

public class sensor {
    // toa do sensor x
    private float x;
    private float y;

    //so huong cua sensor
    private int n;

    // vector sensor


    //khoang cach toi da sensor phat hien dc
    private float rs;



    // get and set

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float getRs() {
        return rs;
    }

    public void setRs(float rs) {
        this.rs = rs;
    }

    //constructor


    public sensor() {
    }

    public sensor(float x, float y, int n, float rs) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.rs = rs;
    }

    // góc phi là góc FOV hiện tại
    public float phi(){
        return (float) (2 * Math.PI) / n;
    }

    //vector node i
    public vector ti(){
        vector dd = new vector(x,y);
        return  dd;
    }

    public int tk(ArrayList<sensor> b){
        for(int i = 0 ; i<b.size();i++){
            if(b.get(i).equals(this)){
                return i+1;
            }
        }
        return -1;
    }

}
