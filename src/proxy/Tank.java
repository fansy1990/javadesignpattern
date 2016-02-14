package proxy;

import java.util.Random;

/**
 * Created by fansy on 2016/2/14.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
