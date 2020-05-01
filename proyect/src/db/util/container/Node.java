package db.util.container;

import java.io.Serializable;

public class Node<T> implements Serializable {

    private static final long serialVersionUID = 5183127516842215343L;

    private T information;

    private Node<T> next;

    public Node(T pInformation){
        next= null;
        this.information = pInformation;
    }

    public Node(Node<T> next, T information) {
        this.next = next;
        this.information = information;
    }

    public void setInformation(T information) {
        this.information = information;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInformation() {
        return information;
    }

    public Node<T> getNext() {
        return next;
    }

    public boolean hasNextNode(){
        return next != null;

    }

    @Override
    public String toString() {
        String result = information.toString()
                + super.toString();
        if (next==null)
            result+="[No next]";
        else result+="--->"+ next;
        return result;
    }
}
