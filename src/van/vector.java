package van;

public class vector {
    private float a;
    private float b;

    public vector(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public vector() {
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    //cong 2 vector
    public vector cong(vector a){
        vector tong = new vector(this.getA()+a.getA(),this.getB()+a.getB());
        return tong;
    }

    //tich vo huong 2 vector
    public float tichvh(vector a){
        return this.getA()*a.getA()+this.getB()+a.getB();
    }

    //tich do dai 2 vector
    public float tichdd(vector a){
        return (float) (Math.sqrt(this.getA()*this.getA()+this.getB()*this.getB())+Math.sqrt(a.getA()*a.getA()+a.getB()*a.getB()));
    }

    //tinh vector nguoc huong
    public vector doi(){
        vector x = new vector(-this.getA(),-this.getB());
        return x;
    }

    //tinh do dai 1 vector
    public float dodai(){
        return (float) Math.sqrt(this.getA()*this.getA()+this.getB()+this.getB());
    }
}
