package van;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

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

    // bài kiểm tra TIS của target đang xét với sensor a đang có hướng là phần thứ n

    public static boolean tis(sensor a,int n,target x){
       
        //vector ngang hướng dang phải
        vector xx = new vector(1,0);
        // tính góc giữa vik và vector xx
        float goc = (float) Math.acos(x.vik(a).tichvh(xx)/x.vik(a).tichdd(xx));
        // nếu target ở nửa dưới hình tròn thì tính lại góc bằng phần còn lại
        if(a.getY()>x.getY())
            goc = (float) (2 * Math.PI)-goc;

        // kiểm tra xem vector vik có nằm trong góc phủ sóng hiện tại hay ko
        if(goc > n * a.phi() || goc < (n-1)*a.phi()){
            return false;
        }

        // kiểm tra xem mục tiêu x có nằm trong phạm vi phủ sóng hay không
        if(x.vik(a).dodai()>a.getRs()) {
            return false;
        }
        return true;
    }
    // tìm tất cả các mục tiêu dc bao phủ bởi cảm biến j có góc j
    public static ArrayList<target> timphiij(sensor i, int j, ArrayList<target> a){
        ArrayList<target> kq = new ArrayList<target>();
        for(int k=0;k<a.size();k++){
            if(target.tis(i,j,a.get(k))){
                kq.add(a.get(k));
            }
        }
        return kq;

    }

    // xay dung ma tran so luong target dc bao phu cua moi sensor voi moi huong
    public static ArrayList getF(sensor ss, ArrayList<target> ds_target){
            ArrayList<Integer> xx = new ArrayList<Integer>();
            for (int j=0;j<ss.getN();j++){
                int dem =0;
                for(int k=0;k<ds_target.size();k++){
                    if(tis(ss,j,ds_target.get(k))){
                        dem++;
                    }
                }
                xx.add(dem);
            }


        return xx;

    }


    // thuat toan tham lam tap trung cga
    public static void cga(ArrayList<sensor> ds_sensor, ArrayList<target> ds_target){
        // tập hợp các cặp (nút hoạt động, định hướng) ở cuối thuật toán là kết quả của CGA
        ArrayList<Map<sensor, Integer>> z = new ArrayList();
        // các mục tiêu chưa được bao phủ
        ArrayList<target> v = ds_target;
        // các sensor không hoạt
        ArrayList<sensor> y = ds_sensor;

            for(int i=0;i<ds_sensor.size();i++){
                ArrayList<Integer> f = getF(ds_sensor.get(i),v);
                int max = -1;
                int huong =0;
                for(int j=0;i<ds_sensor.get(i).getN();j++){
                    if(f.get(j)>max){
                        max = f.get(i);
                        huong =i;
                    }
                }
                // them ij vao z
                Map<sensor,Integer> ij = new Map<sensor, Integer>() {
                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public boolean containsKey(Object key) {
                        return false;
                    }

                    @Override
                    public boolean containsValue(Object value) {
                        return false;
                    }

                    @Override
                    public Integer get(Object key) {
                        return null;
                    }

                    @Override
                    public Integer put(sensor key, Integer value) {
                        return null;
                    }

                    @Override
                    public Integer remove(Object key) {
                        return null;
                    }

                    @Override
                    public void putAll(Map<? extends sensor, ? extends Integer> m) {

                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public Set<sensor> keySet() {
                        return null;
                    }

                    @Override
                    public Collection<Integer> values() {
                        return null;
                    }

                    @Override
                    public Set<Entry<sensor, Integer>> entrySet() {
                        return null;
                    }
                };
                ij.put(ds_sensor.get(i),max);
                z.add(ij);

                // xoa phi ij ra khoi v
                for(int j=0;j<max;j++){
                    ArrayList <target> daphathien = new ArrayList<target>();
                    daphathien = timphiij(ds_sensor.get(i),max,v);
                    for(int k=0;k<daphathien.size();k++){
                        v.remove(daphathien.get(k));
                    }
                }

                // xoa cam bien i ra khoi y
                y.remove(ds_sensor.get(i));
            }


    }


}

