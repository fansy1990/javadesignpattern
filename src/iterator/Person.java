package iterator;

/**
 * Created by fansy on 2016/2/13.
 */
public class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
