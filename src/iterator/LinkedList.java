package iterator;

/**
 * Created by fansy on 2016/2/13.
 */
public class LinkedList implements  Collection{
    private Node head;
    private Node tail ;
    private int size;

    public void add(Object o   ){
        Node current = new Node(o,null);
        if(head==null){
            head = current;
            tail =current;
        }else {
            tail.setNext(current);
            tail = current;
        }
        size ++ ;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator iterator() {
        if(thisIterator==null) thisIterator = new LinkedListIterator();
        return thisIterator;
    }
    private Iterator thisIterator;

    private class LinkedListIterator implements Iterator{
        int curr=0;

        @Override
        public boolean hasNext() {
            if(curr>=size)
            return false;
            else return true;
        }

        @Override
        public Object next() {
            Object o = head;
            head= head.getNext();
            curr ++;
            return o;
        }
    }
}
