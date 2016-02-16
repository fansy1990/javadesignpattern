package singleinstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多例，连接池概念
 * Created by fansy on 2016/2/16.
 */
public class Car {
//    private static Car car ;
    private static int size =2;
    private static List<Car> cars = new ArrayList<>();

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private Car(){}
    private Car(int isze){this.index=isze;}
    static{
        for(int i=0;i<size;i++){
            cars.add(new Car(i));
        }
    }
    static Random random = new Random();
    public static Car getCar(){
        return cars.get(random.nextInt(size));
    }
}
