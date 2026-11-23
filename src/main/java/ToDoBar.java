import java.util.Scanner;
//Идея, автоматическое присвоение номеров для методов,
// заранее только задавать в каждом методе название метода
// но чтобы нумеровка была автоматической

public class ToDoBar {
    private final Scanner scan;
    public ToDoBar(Scanner scan){
        this.scan = scan;
    }

    public void start(ToDoList todoList, ToDoConsole console){
        String options = "===============================" +
                "\n1 - show tasks " +
                "\n2 - show completed tasks " +
                "\n3 - add new task" +
                "\n4 - mark task as completed" +
                "\n5 - remove task" +
                "\n6 - remove task by name" +
                "\n7 - find task" +
                "\n0 - exit";

    while(true){
        System.out.println(options);
        final int userChoice;
            try{
                String userInput = scan.nextLine();
                userChoice = Integer.parseInt(userInput);
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                continue;
            }


        switch (userChoice) {
            case 0:
                return;
            case 1:
                todoList.printTasks();
                break;
            case 2:
                todoList.showCompletedTasks();
                break;
            case 3:
                console.newTasks(todoList);
                break;
            case 4:
                console.askToCompleteTask(todoList);
                break;
            case 5:
                console.askToRemoveTask(todoList);
                break;
            case 6:
                console.askToRemoveTaskByName(todoList);
                break;
            case 7:
                console.askToFoundTask(todoList);
                break;

            default:
                System.out.println("Invalid choice.");

            }
        }
    }
}
