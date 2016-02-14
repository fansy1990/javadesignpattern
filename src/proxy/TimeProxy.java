package proxy;

import proxy.Movable;

/**
 * Created by fansy on 2016/2/14.
 */
public class TimeProxy  implements Movable {
    public TimeProxy(Movable m) {
        this.m = m;
    }

    Movable m;

    @Override
    public void move() {
//        System.out.println();
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }
}
