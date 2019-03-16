package com.company;

/**
 * Created by zachary on 4/7/16.
 */
public class Node extends Data{
    private Node next;

    public Node(String data, Node next) {
        super(data);
        this.next = next;
    }

    public Node(String data){
        super(data);
        this.next = next;
    }



    public void insert(String data){
        if(next != null)
            next.insert(data);
        else
            next = new Node(data);
    }
    public void insert(Node temp){
        if(next != null)
            next.insert(temp);
        else
            next = temp;
    }
    public void display(){
        if(next != null){
            System.out.println(super.getData());
            next.display();
        }
        else
            System.out.println(super.getData());
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
