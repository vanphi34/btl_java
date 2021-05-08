package van;

public class target {
    //toa do target
    private float x;
    private  float y;


    public target(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public target() {
    }



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

    public vector l(){
        return new vector(x,y);
    }

    // tính vector vik là vector giữa sensor tới target
    public  vector vik (sensor a){
        vector x = new vector();
        x = a.ti().doi().cong(l());
        return x;
    }


}

