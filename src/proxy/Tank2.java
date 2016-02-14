package proxy;

/**
 * 继承实现
 * Created by fansy on 2016/2/14.
 */
public class Tank2 extends Tank {
    @Override
    public void move(){
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println((end-start));
    }
}
