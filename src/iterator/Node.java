package iterator;

/**
 * Created by fansy on 2016/2/13.
 */
public class Node {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString(){
        return this.data.toString();
    }
}
