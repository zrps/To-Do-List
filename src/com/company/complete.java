package com.company;

import java.util.ArrayList;

/**
 * Created by zachary on 4/28/16.
 */
public class complete {
    private Node head;

    private ArrayList<Node> compHead;


    public complete() {
        compHead = new ArrayList<Node>();
    }

    public void insert(String data) {
        compHead.add(new Node(data));
    }
    public void insert(Node temp){
        compHead.add(temp);
    }
    public void remove(int i){
        compHead.remove(i);
    }

    public ArrayList<Node> getComp() {
        return compHead;
    }

    public Node get(int i){
        return compHead.get(i);
    }

    public Node getHead() {
        return head;
    }

    public ArrayList<Node> getCompHead() {
        return compHead;
    }




    /*public void insert(Node temp){
        if(head == null)
            head = temp;
        else
            head.insert(temp);
    }
    public void insert(String data){
        if(head == null){
            head = new Node(data);
        }
        else
            head.insert(data);
    }*/
    public void display() {
        if (head == null)
            System.out.println("You have no completed tasks");
        else {
            head.display();
        }
    }
    public Node find(int task){
        Node temp;
        temp = find(head, task);
        return temp;
    }
    public Node find(Node head, int find) {
        {
            if(head == null)
                return null;
            if (find == 1)
                return head;
            else {
                --find;
                return find(head.getNext(), find);
            }
        }
    }
    /*public void remove(int task){
        if(head == null){
            System.out.println("There are no tasks to remove");
        }
        if(task == 1 && head.getNext() == null) {
            head = null;
            return;
        }
        remove(head, task);
    }*/

    public void remove(Node head, int task){
        /*if(head == null)
            return;
        if(head.getNext() == null)
            head = null;*/
        if(task != 1 && head.getNext().getNext() != null){
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
        }*/
        if(task == 1 && head.getNext()!= null){
            head.setNext(head);
        }

    }
    public void removeAll() {
        head = null;
    }


}
