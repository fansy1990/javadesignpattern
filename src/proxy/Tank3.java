package proxy;

/**
 * 继承实现
 * Created by fansy on 2016/2/14.
 */
public class Tank3 {
    public Tank3(Movable t) {
        this.t = t;
    }

    Movable t ;
    public void move(){
        long start = System.currentTimeMillis();
//        super.move();
        t.move();
        long end = System.currentTimeMillis();
        System.out.println((end-start));
    }
}
