import java.util.InputMismatchException;
import java.util.Scanner;


public class ToDoConsole {

    private final Scanner scan;
    public ToDoConsole(Scanner scan){
        this.scan = scan;
    }
    private int readInt(){
        while(true){
            try{
                int taskAmount = Integer.parseInt(scan.nextLine());
                return taskAmount;
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
            }
        }
    }


    public void newTasks(ToDoList todoList) {
        while (true) {
        System.out.println("How many task do you want to add?: ");
            int taskAmount = readInt();
            if (taskAmount == 0) {
                System.out.println("Invalid number");
                continue;
            }
            if (taskAmount < 0) {
                System.out.println("Number of task can't be negative");
                continue;
            }
                for (int i = 0; i < taskAmount; i++) {
                    while (true){
                        System.out.print((i + 1) + ". ");
                    try {
                        Priority priority;
                        String newTask = scan.nextLine();
                        if (newTask == null || newTask.isBlank()){
                            throw new IllegalArgumentException("Task can't be empty");
                        }
                        while (true) {
                            System.out.println("Choose priority:\n" +
                                    "1. LOW\n" +
                                    "2. MEDIUM\n" +
                                    "3. HIGH");

                            int userChoice = readInt();
                            switch (userChoice) {
                                case 1:
                                    priority = Priority.LOW;
                                    break;
                                case 2:
                                    priority = Priority.MEDIUM;
                                    break;
                                case 3:
                                    priority = Priority.HIGH;
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    continue;
                            }

                            todoList.addTask(newTask, priority);
                            break;
                        }break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

            }

        }return;

        }
    }


    public void askToCompleteTask(ToDoList todoList) {
        System.out.println("Which task would you like to set as completed?");
            int taskNumber = readInt();
                todoList.completedTask(taskNumber);

    }

    public void askToRemoveTask(ToDoList todoList) {
        System.out.println("Which task would you like to remove?");
            int inputTaskNumber = readInt();
            todoList.removeTask(inputTaskNumber);
    }

    public void askToRemoveTaskByName(ToDoList todoList){
        System.out.println("Which task would you like to remove?");
        String inputTaskName = scan.nextLine();
        todoList.removeTaskByName(inputTaskName);
    }

    public void askToFoundTask(ToDoList todoList){
        System.out.println("Which task would you like to found?" +
                "\n//write some word from the task");
        String inputWord = scan.nextLine();
        todoList.findTask(inputWord);
    }

    }
