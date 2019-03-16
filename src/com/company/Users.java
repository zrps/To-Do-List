package com.company;
import sun.awt.UNIXToolkit;

import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zachary on 4/7/16.
 */
//set up bst potentially to manage users

public class Users {
    private Tree root;
    private ArrayList<Tree> UsersHead;

    public Users() {
        UsersHead = new ArrayList<Tree>();
    }
    public void insert(String userName, char[] pW){
        UsersHead.add(new Tree(userName,pW));
    }
    public ArrayList<Tree> getUsersHead(){
        return UsersHead;
    }
    public void insert(Tree temp){
        UsersHead.add(temp);
    }
    public Tree check(String UN, char [] PW){
        for(Tree i: UsersHead){
            if(i.getUsername().equals(UN) && Arrays.equals(i.getPassword(), PW)){
                return i;
            }
        }
        return null;
    }

    //each node has those those three lists in it. if the user logs in they can view those three
    public void load() throws IOException {
        Scanner scan = new Scanner("src/com/company/users.txt");
        String treeInsert  = "src/com/company/users.txt";
       // File file = new File(treeInsert);
        FileInputStream fstream = new FileInputStream("src/com/company/users.txt");
        DataInputStream dstream = new DataInputStream(fstream);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(dstream));
        BufferedReader reader = new BufferedReader(new FileReader("src/com/company/users.txt"));
        StringBuilder build = new StringBuilder();
       // String content = new Scanner(new File("src/com/company/users.txt")).useDelimiter("\\Z").next();//test
      //  System.out.println(content);
        //String userInsert;

        String UNInsert;
        String PWInsert;
        String todo;
        String inProgress;
        String comp;
        int breakString;
        Tree rootTemp;
        //BufferedReader lists = new BufferedReader(todo);
        while((treeInsert = reader.readLine())!=null) {
            String[] split = treeInsert.split("&");
            UNInsert = split[0];
            PWInsert = split[1];
            char[] PW = PWInsert.toCharArray();
            Tree rootInsert = new Tree(UNInsert, PW);
            //if(!split[2].equals("")){

            if (rootInsert.getToDo() == null)
                rootInsert.setToDo(new toDoList());
            if(rootInsert.getInProg() == null)
                rootInsert.setInProg(new progress());
            if(rootInsert.getComp() == null)
                rootInsert.setComp(new complete());
            try {
                todo = split[2];
                String[] todoSplit = todo.split(";");
                int todoLength = todoSplit.length;

                for (int i = 0; i < todoLength; ++i) {
                    rootInsert.getToDo().insert(todoSplit[i]);
                }
            }catch(ArrayIndexOutOfBoundsException e){
               System.out.println("todo is empty");
            }
           // }
            try {
                inProgress = split[3];
                String []inProgSplit = inProgress.split(";");
                int inProgLength = inProgSplit.length;

                for(int i = 0; i < inProgLength; ++i){
                    rootInsert.getInProg().insert(inProgSplit[i]);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("progress is empty");
            }
            try {
                comp = split[4];
                String []compSplit = comp.split(";");
                int compLength = compSplit.length;

                for(int i = 0; i < compLength; ++i){
                    rootInsert.getComp().insert(compSplit[i]);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("complete is empty");
            }



           // rootInsert.setToDo(new toDoList());
            //rootInsert.setInProg(new progress());
            //rootInsert.setComp(new complete());



            insert(rootInsert);

/*            while(!todo.contains("\0")){//split each list into three strings THEN insert it into the node. then insert the node into the tree(users?)
                breakString = todo.indexOf(";");
                String todoTemp = treeInsert.substring(0,breakString);
                rootInsert.getToDo().insert(todoTemp);
            }
            while(!inProgress.contains("\0")){
                breakString = inProgress.indexOf(";");
                String inProgTemp = treeInsert.substring(0,breakString);
                rootInsert.getInProg().insert(inProgTemp);
            }
            while(!comp.contains("\0")){
                breakString = comp.indexOf(";");
                String compTemp = treeInsert.substring(0,breakString);
                rootInsert.getComp().insert(compTemp);*/

            //rootTemp = create(UNInsert,PW);//create a treenode fully then insert into tree
           // rootTemp


            //System.out.println(treeInsert);

        }

    }
    public void exit(){

            try {
                PrintWriter PW = new PrintWriter("src/com/company/users.txt");
                PW.print("");
                PW.close();
            }catch(IOException ex){
                System.out.println("Printerwriter cannot find file");
            }
        exit(UsersHead);
    }
    public void exit(ArrayList<Tree> root){

        for(Tree j: UsersHead){

            StringBuilder USER = new StringBuilder();
            StringBuilder TODO = new StringBuilder();
            StringBuilder PROG = new StringBuilder();
            StringBuilder COMP = new StringBuilder();
            String PWCONVERT = new String(j.getPassword());
            for (Node i : j.getToDo().getTodo()) {
                TODO.append(i.getData()).append(";");
            }
            for (Node i : j.getInProg().getInProgHead()) {
                PROG.append(i.getData()).append(";");
            }
            for (Node i : j.getComp().getComp()) {
                COMP.append(i.getData()).append(";");
            }
            USER.append(j.getUsername()).append("&").append(PWCONVERT).append("&").append(TODO).append("&").append(PROG).append("&").append(COMP).append("\n");
            // System.out.println("USER: "+ USER + "\nTODO: " + TODO + "\nPROG: "+ PROG + "\nCOMP: " + COMP + "PW")
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/company/users.txt",true));
                bw.write(USER.toString());
                bw.close();
            } catch (IOException ex) {
                System.out.println("Failed To save");
            }
            //root = root.getNext();
        }
       /* if(root.getRight()!= null){
            return exit(root.getRight());
        }
        if(root.getLeft()!= null){
            return exit(root.getLeft());
        }
        else
            return null;*/
    }
    public void close(){

    }
    public void addToDo(String add){
        root.getToDo().insert(add);
    }


    public Tree create(Tree rootInsert){
        if(root == null){
            root = rootInsert;
            return root;
        }
        return create(root, rootInsert);


    }
    public Tree create(Tree root, Tree rootInsert){
        if(root == null){
            root = rootInsert;
            root.setLeft(null);
            root.setRight(null);
            return root;
        }
        if(rootInsert.getUsername().length() > root.getUsername().length()){
            return create(root.getLeft(), rootInsert);
        }
        else
            return create(root.getRight(),rootInsert);
    }
    public Tree create(String userName, char[] password){
        if(root == null){
            root = new Tree(userName,password);
            return root;
        }
        return create(root, userName,password);

    }
    public Tree create(Tree root, String userName, char[] password){
        if(root == null){
            root = new Tree(userName,password);
            return root;
        }
        if(root.getUsername().length() > userName.length()){
            return create(root.getLeft(), userName,password);
        }
        else{
            return create(root.getRight(),userName,password);
        }
        //if(root.getUsername())
    }
    /*public Tree check(String UserName, char[] Password) {
        return check(root, UserName, Password);
    }
    public Tree check(Tree root, String Username, char[] Password){
        if(root == null)
            return null;
        if(root.getUsername().equals(Username)){
             if(Arrays.equals(Password, root.getPassword()))
             {
                 return root;
             }
        }
        else {
            if(root.getLeft() !=  null)
                return check(root.getLeft(), Username, Password);
            if(root.getRight() != null)
                return check(root.getRight(), Username, Password);
        }
        return null;

    }*/

    public void display(){
        root.getToDo().display();
    }

    public static void main(String[] args) {

    }
}
