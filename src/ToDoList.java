import java.util.ArrayList;
import java.util.Arrays;


public class ToDoList {
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<Boolean> completed = new ArrayList<>();


    public void addDefaultTasks() {
        addTask("Learn some Java");
        addTask("Prepare for a test");
    }


    public void addTask(String task) {
        if (task == null || task.isBlank()){
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        tasks.add(task);
        completed.add(false);
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            String status = completed.get(i) ? " -- Status: Completed: " : " -- Status: Not completed";
            int taskIndex = i + 1;
            System.out.println(taskIndex + ". " + tasks.get(i) + status);
        }

    }

    public void completedTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index >= 0 && index < tasks.size()) {
            completed.set(index, true);
            System.out.println(tasks.get(index) + " is now completed.");
        } else {
            System.out.println("This number is not in the list");
        }

    }

    public void showCompletedTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            if (completed.get(i)) {
                String status = completed.get(i) + " -- Status: Completed: ";
                int taskIndex = i + 1;
                System.out.println(taskIndex + ". " + tasks.get(i) + status);

        }
    }
}
    public void removeTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index >= 0 && index < tasks.size()) {
            String name = tasks.get(index);
            completed.remove(index);
            tasks.remove(index);
            System.out.println(name + " is now removed.");
        }
    }
    public void findTask(String nameOfTask) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toLowerCase().contains(nameOfTask.toLowerCase())) {
                found = true;
                System.out.println(tasks.get(i) + " is found.");
            }
        }if (found == false) {
            System.out.println("This name is not found the list");
        }
    }

    public void removeTaskByName(String nameOfTask) {
        boolean found = false;

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).toLowerCase().contains(nameOfTask.toLowerCase())){
                found = true;
                String name = tasks.get(i);
                completed.remove(i);
                tasks.remove(i);
                System.out.println(name + ": Is now removed");
                return;
            }
        }

        if (found == false){
            System.out.println(nameOfTask + ": Is not found. The task is not removed");
        }
    }

}

