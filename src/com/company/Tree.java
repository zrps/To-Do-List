package com.company;
import java.util.*;


/**
 * Created by zachary on 5/3/16.
 */
public class Tree {
    private Tree next;
    private Tree left;
    private Tree right;
    private toDoList toDo;
    private progress inProg;
    private complete comp;
    private String username;
    private char[] password;

    public Tree(Tree left, Tree right, toDoList toDo, progress inProg, complete comp, String username, char[] password) {
        this.left = left;
        this.right = right;
        this.toDo = toDo;
        this.inProg = inProg;
        this.comp = comp;
        this.username = username;
        this.password = password;
    }

    public Tree getNext() {
        return next;
    }

    public void setNext(Tree next) {
        this.next = next;
    }

    public Tree(String username, char[] password) {
        this.username = username;
        this.password = password;
    }
    public Tree(){

    }
    public void insertToDo(String data){
        toDo.insert(data);
    }
    public void getDisplay(){
        toDo.display();
    }
    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public ArrayList<Node> getToDoListHead() {
        if(toDo == null) {
            System.out.println("todo is null");
            return null;
        }
        else {
            System.out.println("todo is not null");
            return toDo.getTodo();
        }
    }
    public toDoList getToDo(){
        return toDo;
    }

    public void setToDo(toDoList toDo) {
        this.toDo = toDo;
    }

    public progress getInProg() {
        return inProg;
    }

    public void setInProg(progress inProg) {
        this.inProg = inProg;
    }

    public complete getComp() {
        return comp;
    }

    public void setComp(complete comp) {
        this.comp = comp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
