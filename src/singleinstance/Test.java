package singleinstance;

/**
 * Created by fansy on 2016/2/16.
 */
public class Test {
    public static void main(String[] args){
        for(int i=10;i>0;i--) {
            Car c = Car.getCar();

            System.out.println(c);
        }
    }
}
