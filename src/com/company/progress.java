package com.company;
import java.util.*;


/**
 * Created by zachary on 4/12/16.
 */
//need remove
public class progress {
    private Node head;
    private ArrayList<Node> inProgHead;


    public progress() {
        inProgHead = new ArrayList<Node>();
    }

    public void insert(String data) {
        inProgHead.add(new Node(data));
    }
    public void insert(Node temp){
        inProgHead.add(temp);
    }
    public void remove(int i){
        inProgHead.remove(i);
    }

    public ArrayList<Node> getProg() {
        return inProgHead;
    }

    public Node get(int i){
        return inProgHead.get(i);
    }

    public Node getHead() {
        return head;
    }

    public ArrayList<Node> getInProgHead() {
        return inProgHead;
    }

    public String find(){
        if(head == null){
            return null;
        }
        System.out.println(head.getData());
        return head.getData();
    }


    /*public void insert(String data){
        if(head == null)
            head = new Node(data);
        else
            head.insert(data);
    }
    public void insert(Node temp){
        if(head == null)
            head = temp;
        else
            head.insert(temp);

    }*/
    public void display(){
        if(head == null){
            System.out.println("You have no in progress tasks.");
        }
        head.display();
    }
    public Node find(int task){
        Node temp;
        temp = find(head, task);
        return temp;
    }
    public Node find(Node head, int find){
        if(find == 1)
            return head;
        else {
            --find;
            return find(head.getNext(), find);
        }
    }
   /* public void remove(int task){
        if(head == null){
            System.out.println("There are no tasks to remove");
        }
        if(task == 1 && head.getNext() == null) {
            head = null;
            return;
        }
        remove(head, task);
    }
    public void remove(Node head, int task){
        if(task != 1 && head.getNext().getNext() != null){//problem. Exception NULLPOINTEREXCEPTION
            --task;
            remove(head.getNext(),task);
        }
        if(task == 2 && head.getNext().getNext() == null && head.getNext() != null){
            head.setNext(null);
            return;
        }
        if(task == 2 && head.getNext().getNext() != null){//may never be reached due to first if statement. maybe change first statement to != 2?
            head.setNext(head.getNext().getNext());
            return;
        }
        if(task != 1 && head.getNext() == null){
            System.out.println("Cannot be removed. Cannot find task.");
            return;
        }
      /*  if(task == 1 && head.getNext() == null){
            head = null;
            return;
        }
        if(task == 1 && head.getNext()!= null){
            head.setNext(head);
        }

    }*/

}
