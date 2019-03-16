package com.company;
import java.util.ArrayList;
/**
 * Created by zachary on 4/7/16.
 */
public class toDoList {
    private Node head;
    private ArrayList<Node> toDoHead;

    public toDoList() {
        toDoHead = new ArrayList<Node>();
    }
    public toDoList(Node item){
        toDoHead = new ArrayList<Node>();
        toDoHead.add(item);

    }

    public void insert(String data) {
        if(toDoHead == null){
            toDoHead = new ArrayList<Node>();
        }
        toDoHead.add(new Node(data));
    }
    public void remove(int i){
        toDoHead.remove(i);
    }

    public ArrayList<Node> getTodo() {
        return toDoHead;
    }
    public void insert(Node temp){
        if(toDoHead == null)
            toDoHead = new ArrayList<Node>();
        toDoHead.add(temp);
    }
    public Node get(int i){
        return toDoHead.get(i);
    }
    /* public void insert(String data){
        toDoHead.add(new Node(data));
        toDoHead.remove(3);
        toDoHead.get(2).getData();
        System.out.println(data);
        if(head == null){
            head = new Node(data);
            head.setNext(null);
        }
        else
            insert(head, data);
    }*/
  /*  public Node insert(Node head, String data){
        if(head != null){
            return insert(head.getNext(),data);
        }
        head = new Node(data);
        head.setNext(null);
        return head;
    }*/

    public void display(){
        if(head == null){
            System.out.println("You have no current tasks.");
            return;
        }
        head.display();
    }
    /*public void remove(int task){//needs to be called and FINISH THIS
        if(head == null){
            System.out.println("There are no tasks to remove");
        }
        if(task == 1 && head.getNext() == null) {
            head = null;
            return;
        }
        remove(head, task);
    }*/
    public String find(){
        if(head == null){
            return null;
        }
        System.out.println(head.getData());
        return head.getData();
    }
    /*public Node remove(Node head, int task){
       /* if(task == 1 && head.getNext() == null) {
            head = null;
            return null;
        }
        if(task != 1 && head.getNext().getNext() != null){
            --task;
            remove(head.getNext(),task);
        }
        if(task == 2 && head.getNext().getNext() == null && head.getNext() != null){
            head.setNext(null);
            return head;
        }
        if(task == 2 && head.getNext().getNext() != null){//may never be reached due to first if statement. maybe change first statement to != 2?
            head.setNext(head.getNext().getNext());
            return head;
        }
        if(task != 1 && head.getNext() == null){
            System.out.println("Cannot be removed. Cannot find task.");
            return head;
        }

        if(task == 1 && head.getNext()!= null){
            //head.setNext(head);//may not work
            Node temp = head;
            head = head.getNext();
            temp = null;
            return head;
        }
        return head;
    }*/
    public Node find(int task){
        Node temp;
        temp = find(head, task);
        return temp;
    }
    public Node find(Node head, int find){
        if(find == 1)
            return head;
        if(head == null){
            System.out.println("Null");
            return null;
        }
        else {
            --find;
            return find(head.getNext(), find);
        }
    }

}
