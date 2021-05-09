package van;

import java.util.*;

public class Main {




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
    // tìm tất cả các mục tiêu dc bao phủ bởi cảm biến i có góc j
    public static ArrayList<target> timphiij(sensor i, int j, ArrayList<target> a){
        ArrayList<target> kq = new ArrayList<target>();
        for(int k=0;k<a.size();k++){
            if(tis(i,j,a.get(k))){
                kq.add(a.get(k));
            }
        }
        return kq;

    }

    // xay dung ma tran so luong target dc bao phu cua moi sensor voi moi huong
    public static ArrayList getF(ArrayList<sensor> ss, ArrayList<target> ds_target){
        ArrayList<ArrayList<Integer>> a = new ArrayList();
        ArrayList<Integer> xx = new ArrayList<Integer>();
        for (int i=0;i<ss.size();i++){
            for (int j=0;j<ss.get(i).getN();j++){
                int dem =0;
                for(int k=0;k<ds_target.size();k++){
                    if(tis(ss.get(i),j,ds_target.get(k))){
                        dem++;
                    }
                }
                xx.add(dem);
            }
            a.add(xx);
        }
        return a;
    }


    // thuat toan tham lam tap trung cga
    public static void cga(ArrayList<sensor> ds_sensor, ArrayList<target> ds_target){
        // tập hợp các cặp (nút hoạt động, định hướng) ở cuối thuật toán là kết quả của CGA
        ArrayList<Map<sensor, Integer>> z = new ArrayList();
        // các mục tiêu chưa được bao phủ
        ArrayList<target> v = ds_target;
        // các sensor không hoạt
        ArrayList<sensor> y = ds_sensor;


        ////// xu ly lai doan nay

        while (true){


            if(v.isEmpty() || y.isEmpty()){
                break;
            }
            ArrayList<ArrayList<Integer>> a = getF(y,v);
            int max = 0;
            sensor index_sensor = new sensor();
            int index_huong =0;
            for(int i=0;i<y.size();i++){
                for(int j=0;j<y.get(i).getN();j++){
                    if(timphiij(y.get(i),j,v).size()>max){
                        max = timphiij(y.get(i),j,v).size();
                        index_sensor = y.get(i);
                        index_huong = j;
                    }
                }
            }
            if(max==0){
                break;
            }
            else {
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
                ij.put(index_sensor,index_huong);
                z.add(ij);

                // xoa phi ij ra khoi v
                for(int j=0;j<max;j++){
                    ArrayList <target> daphathien = new ArrayList<target>();
                    daphathien = timphiij(index_sensor,index_huong,v);
                    for(int k=0;k<daphathien.size();k++){
                        v.remove(daphathien.get(k));
                    }
                }
                // xoa cam bien i ra khoi y
                y.remove(index_sensor);
            }

        }

    }

    // thuật toán tham lam phân tán dga

    public static void dga(){

    }

//    public static ArrayList<Integer>  get_phi_ij(ArrayList<sensor> ds_sensor, ArrayList<target> ds_target ){
//            ArrayList<ArrayList> ax = new ArrayList<ArrayList>();
//            for(int i=0;i<ds_sensor.size() ;i++){
//                ArrayList<ArrayList> ay = new ArrayList<ArrayList>();
//                ax.add(ay);
//                for(int j=0;j<ds_sensor.get(i).getN();j++){
//                    ay.add(target.timphiij(ds_sensor.get(i),j,ds_target)) ;
//                }
//            }
//            return null;
//    }

//    public static void (ArrayList<ArrayList> f, ArrayList<sensor> ds_sensor, ArrayList<target> ds_target ){
//        //danh sach cac cam bien hoat dong
//        ArrayList<sensor> z = new ArrayList<sensor>();
//        //danh sach cac muc tieu khong dc bao phu
//        ArrayList<target> v = new ArrayList<target>();
//        //danh sach cac cam bien dang khong hoat dong
//        ArrayList<sensor> y = ds_sensor;
//
//        while (true){
//            for(int i=0;i<)
//        }
//    }

    public static void main(String[] args) {
        // write your code here


        // tạo danh sách 10 mục tiêu ngẫu nhiên
        ArrayList<target> aa = new ArrayList<target>();
        for(int i=0;i<10;i++){
            Random r = new Random();
            int rd1 = r.nextInt(10);
            int rd2 = r.nextInt(10);
            rd1 += r.nextDouble();
            rd2 += r.nextDouble();

            target x = new target(rd1,rd2);
            aa.add(x);
        }

        // tạo danh sách 5 cảm biến ngẫu nhiên
        ArrayList<sensor> bb = new ArrayList<sensor>();
        for(int i=0;i<5;i++){
            Random r = new Random();
            int rd1 = r.nextInt(10);
            int rd2 = r.nextInt(10);
            rd1 += r.nextDouble();
            rd2 += r.nextDouble();
            sensor x = new sensor(rd1,rd2,8,4);

            bb.add(x);
        }





//        for(int i=0;i<a.getN();i++){
//            if(target.tis(a,i,b))
//                System.out.println("hihi");
//            else
//                System.out.println("kkk");
//        }

    }


}
