import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);

        ToDoList todoList = new ToDoList();
        ToDoConsole console = new ToDoConsole(scan);
        ToDoBar todoBar = new ToDoBar(scan);
        CategoriesHashSet category = new CategoriesHashSet();


        System.out.println("=== To-Do List ===");

        category.addCategory("Study");
        category.addCategory("Work");
        category.addCategory("Sport");
        category.addCategory("work");
        category.removeCategory("Study");
        category.showCategories();

        todoList.addDefaultTasks();
        todoBar.start(todoList, console);

        System.out.println();
        System.out.println("End of List.");


    }
}

















//        System.out.println();
//        System.out.println("Tasks:");
//
//        todoList.addDefaultTasks();
//
//        todoList.addTask("Read Book");
//        todoList.addTask("Sky Diving");
//
//        console.askToCompleteTask(todoList);
//
//        todoList.printTasks();