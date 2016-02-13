package iterator;

/**
 * Created by fansy on 2016/2/13.
 */
public class Test {
    public static void main(String[] args){
        Collection ll= new LinkedList();

        ll.add(new Person("tt1"));
        ll.add(new Person("tt2"));
        ll.add(new Person("tt3"));

        Iterator iterator = ll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.print(ll.size());
    }
}
