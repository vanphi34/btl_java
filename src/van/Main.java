package van;

import java.util.ArrayList;
import java.util.Random;

public class Main {



    public static ArrayList<Integer>  get_phi_ij(ArrayList<sensor> ds_sensor, ArrayList<target> ds_target ){
            ArrayList<ArrayList> ax = new ArrayList<ArrayList>();
            for(int i=0;i<ds_sensor.size() ;i++){
                ArrayList<ArrayList> ay = new ArrayList<ArrayList>();
                ax.add(ay);
                for(int j=0;j<ds_sensor.get(i).getN();j++){
                    ay.add(target.timphiij(ds_sensor.get(i),j,ds_target)) ;
                }
            }
            return null;
    }

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
