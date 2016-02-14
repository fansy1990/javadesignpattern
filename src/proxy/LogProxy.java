package proxy;

/**
 * Created by fansy on 2016/2/14.
 */
public class LogProxy implements Movable {
    public LogProxy(Movable m) {
        this.m = m;
    }

    Movable m;

    @Override
    public void move() {
        System.out.println("Tank start...");
        m.move();
        System.out.println("Tank end...");
    }
}
