import java.util.ArrayList;
public class TaskTest {
    public static void main(String[] args) {
        ArrayList<Task> tasks =  new ArrayList<Task>();
        Task task = new Task("Learn Java", Priority.HIGH);
        Task task2 = new Task("Learn Cooking", Priority.MEDIUM);
        task.setCompleted(true);
        System.out.println(task.getName() + " " + task.isCompleted() + " " + task.getPriority());
        tasks.add(task);
        tasks.add(task2);
        System.out.println(tasks.size());

        Task selectedTask = tasks.get(1);
        System.out.println(selectedTask.getName() + " " + selectedTask.getPriority());
        selectedTask.setCompleted(true);
        System.out.println(selectedTask.isCompleted());

        for(int index = 0; index < tasks.size(); index++){
            System.out.println((index + 1) + ". " + tasks.get(index).getName() +
                    " " + tasks.get(index).getPriority()  +
                    " " + tasks.get(index).isCompleted());
        }

    }
}
