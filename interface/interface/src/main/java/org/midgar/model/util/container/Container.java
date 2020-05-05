package org.midgar.model.util.container;


public class Container<T> {
    private int size;
    private Node<T> head;

    public Container() {
        head = null;
    }

    // GETTERS AND SETTERS
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    //METHODS

    public boolean upadateNode(int index, T data) {
        //get the node
        Node<T> temp = nodeDataAtIndex(index);

        //if the node exist change the data else send false
        if (temp != null) {
            temp.setInformation(data);
            return true;
        } else {
            return false;
        }


    }

    public Node<T> nodeDataAtIndex(int index) {
        //objects
        Node<T> temp = head;

        //si el índice es más grande que el tamaño de la lista o es un número negativo, no devuelve nada
        if (index > size || index < 0) {
            return null;
        } else {
            //se itera en la lista hasta obtener el nodo y establecer el nodo en el siguiente
            for (int i = 0; temp != null && i < index; i++) {

                temp = temp.getNext();
            }
            return temp;
        }
    }

    public void add(T nodeData) {
        if (head == null) {
            head = new Node<>(nodeData);

        } else {
            Node<T> temp = head;
            Node<T> newNode = new Node<>(nodeData);
            // se mueve a través de los nodos hasta obtener el último, sin "getNext" para asignar el nuevo nodo.
            while (true) {
                if (!temp.hasNextNode()) {
                    temp.setNext(newNode);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }
        size++;// incrementa el tamaño de la lista.

    }

    public boolean delete(int index) {
        Node<T> temp = head;
        // si no hay nodos en la lista.
        if (head == null) {
            return false;
        } else if (index > size || index < 0)// si el indice es mas grande que el tamaño de la lista o un valor negativo.
        {
            return false;
        } else {
            if (index == 0)// si el nodo a eliminar es el primero en la lista
                head = temp.getNext();// el nuevo nodo sera igual a la segunda refencia.
            else {
                // encuentra el anterior nodo del cual se eliminara
                for (int i = 0; temp != null && i < index - 1; i++) {
                    temp = temp.getNext();
                }
                // se establece nextNode es igual al siguiente para eliminar la referencia.
                assert temp != null;
                Node<T> nextNode = temp.getNext().getNext();// mas de uno aqui le estallo la head xd.

                // se establece este nodo como el siguiente nodo de el que se eliminara de la referencia.
                temp.setNext(nextNode);
                size--;
            }
            return true;
        }
    }
    public void showNodes(){
        Node<T> temp= head;
        // itera in los nodos y sus datos
        for (int i =0; temp!=null;i++){
            System.out.println("The data of element: ["+i+"] is ["+temp.getInformation()+"]");
            temp= temp.getNext();
        }
        // para despues sera implimentear esto con un for each pls.
    }

    @Override
    public String toString() {
        return "Container{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }
}
