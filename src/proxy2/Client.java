package proxy2;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fansy on 2016/2/14.
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


//        Movable m= timeProxy;
//        m.move();
        Movable m = (Movable) Proxy.getNewProxy(Movable.class,new Tank());
        m.move();
        m.stop();
    }
}
