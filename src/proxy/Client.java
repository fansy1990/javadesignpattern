package proxy;

/**
 * Created by fansy on 2016/2/14.
 */
public class Client {
    public static void main(String[] args) {
//        Movable t = new Tank2();
//        t.move();

        Tank t = new Tank ();
//       先记录时间然后记录日志
//        TimeProxy timeProxy = new TimeProxy(t);
//        LogProxy logProxy = new LogProxy(timeProxy);
//        Movable m= logProxy;
        // 先记录日志，然后记录时间
        LogProxy logProxy = new LogProxy(t);
        TimeProxy timeProxy = new TimeProxy(logProxy);

        Movable m= timeProxy;
        m.move();
    }
}
