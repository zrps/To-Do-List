package com.company;
import javax.swing.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws IOException{
	// write your code here
        Scanner insert = new Scanner(System.in);
        //Users person = new Users();
        //person.load();


        //Scanner scan = new Scanner(new File(input));
        //Login user = new Login();
       /* String file = "users.txt";
        String line;
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(filereader);
           /* while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }*/
           /* while(insert.hasNextLine()){

            }
            bufferReader.close();//closes file. ALWAYS DO
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open '" + file + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Users user = new Users();
        user.userMain();*/
        Login.main(args);

    /*    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                PrintWriter pw = new PrintWriter("src/com/company/users.txt");
                pw.close();
            }
        }, "Shutdown-thread"));*/






        toDoList toDo = new toDoList();
        progress prog = new progress();
        complete comp = new complete();
        Users account = new Users();
        Node check;
        boolean run = true;
        boolean start = false;
        boolean quit = false;
        boolean create = false;
        boolean task1;//continues loop to keep adding to do items if desired
        boolean task2;
        boolean task3;
        int task;
        int toDoAsk;//Used to store int for user input relating to the to do list
        int progAsk;//used for task 2 to choose function calls and end while loop
        int compAsk;
        String add;


/*
        while(!start && !quit && !create){//need to create action listener/listener
            start = user.logPressed();
            create = user.createPressed();
            quit = user.quitPressed();
        }
        if(start){
            boolean signIn;
            String password = String.valueOf(user.getPasswordField1());
            String username = String.valueOf(user.getLoginButton());
            signIn = account.check(username,password);
            if(signIn){
                //start program if username and password match
            }
            else
            {
                //incorrect password
            }
        }
        if(create){

        }
        if(quit){
            System.exit(0);//Quits program is user selects quit
        }*/

        while(run) {
            System.out.println("1.To Do\n2.In Progress\n3.Completed\n4.Quit");//Main UI/Home Login
            task = insert.nextInt();
            if(task == 1) {
                task1 = true;
                while(task1) {
                    System.out.println("To Do");//Prints list for to do list
                    toDo.display();
                    System.out.println("1.Add\n2.Move to \"In Progress\"\n3.Back");//asks the user if they wish to add another item to the list or return to the home menu
                    toDoAsk = insert.nextInt();
                    if (toDoAsk == 1) {
                        System.out.println("Next task: ");
                        add = insert.next();
                        toDo.insert(add);
                    }
                    if(toDoAsk == 2){
                        int toMove;//used to determine which user task needs to be removed
                        System.out.println("Which task would you like to move?");
                        toMove = insert.nextInt();
                        check = toDo.find(toMove);//checks if the returned node exists or not
                        if(check == null){
                            System.out.println("Can't find item to move.");
                        }
                        else {
                            prog.insert(toDo.find(toMove));
                            toDo.remove(task);
                        }
                        /*
                        need to implement way to remove node and move it to another list
                         */

                    }
                    if (toDoAsk == 3) {
                        task1 = false;
                    }
                    else if(toDoAsk >= 4){
                        System.out.println("Please input a correct number.");
                    }
                }
            }
            if(task == 2){
                task2 = true;
                while(task2){
                    int toComplete;
                    System.out.println("In Progress");
                    prog.display();
                    System.out.println("1.Move to Complete\n2.Back");
                    progAsk = insert.nextInt();
                    if(progAsk == 1){
                        System.out.println("Which would you like to mark as complete?");
                        toComplete = insert.nextInt();
                        check = prog.find(toComplete);
                        if(check == null){
                            System.out.println("Can't find item to complete.");
                        }
                        else{
                            comp.insert(prog.find(toComplete));
                            prog.remove(task);// exception ERROR
                        }
                        //move in progress to complete
                    }
                    if(progAsk == 2){
                        task2 = false;
                    }
                    else if(progAsk >= 3){
                        System.out.println("Please input a correct number.");
                    }
                }
            }
            if (task == 3) {
                task3 = true;
                int toRemove;
                while(task3){
                    System.out.println("Completed");
                    comp.display();
                    System.out.println("1.Permanently delete\n2.RemoveAll\n3.Back");
                    compAsk = insert.nextInt();
                    if(compAsk == 1){
                        System.out.println("Which would you like to permanently delete?");
                        toRemove = insert.nextInt();
                        check = comp.find(toRemove);
                        if(check == null){
                            System.out.println("Cant find item to remove.");
                        }
                        else
                            comp.remove(toRemove);
                    }
                    if(compAsk == 2){
                        System.out.println("Are you sure you want to remove all completed items from this list? It cannot be undone. (Y/N)");
                        String choice;
                        choice = insert.next();
                        choice = choice.toUpperCase();
                        if(Objects.equals(choice, "Y")){
                            comp.removeAll();
                            task3 = false;
                        }
                        else{
                            if(!Objects.equals(choice, "N")){
                                System.out.println("Please input Y or N");
                            }
                        }


                    }
                    if(compAsk == 3){
                        task3 = false;
                    }
                }
                /*
                Display
                Delete/remove
                 */
            }
            if(task == 4)
                run = false;
        }

    }
}
