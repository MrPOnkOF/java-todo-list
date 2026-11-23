import java.util.ArrayList;


public class ToDoList {
    private ArrayList<Task> tasks =  new ArrayList<>();


    public void addDefaultTasks() {
        addTask("Learn some Java", Priority.HIGH);
        addTask("Prepare for a test", Priority.HIGH);
    }


    public void addTask(String name, Priority priority) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        Task newTask = new Task(name, priority);
        tasks.add(newTask);
    }


    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            String status = currentTask.isCompleted() ? " -- Status: Completed: " : " -- Status: Not completed";
            int taskIndex = i + 1;
            System.out.println(taskIndex + ". " + currentTask.getName()
                    + status + " -- Priority: " + currentTask.getPriority());
        }

    }

    public Task getTask(int TaskNumber){
        return tasks.get(TaskNumber - 1);
    }

    public int getTaskCount(){
        return tasks.size();
    }

    public void completedTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index >= 0 && index < tasks.size()) {
            Task currentTask = tasks.get(index);
            currentTask.setCompleted(true);
            System.out.println(currentTask.getName() + " is now completed.");
        } else {
            System.out.println("This number is not in the list");
        }

    }

    public void showCompletedTasks() {
        for (int index = 0; index < tasks.size(); index++) {
            Task currentTask = tasks.get(index);
            if (currentTask.isCompleted()) {
                String status = " -- Status: Completed ";
                String priority = " -- Priority: " + currentTask.getPriority();
                int taskIndex = index + 1;
                System.out.println(taskIndex + ". " + currentTask.getName() + status
                + priority);

        }
    }
}
    public void removeTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index >= 0 && index < tasks.size()) {
            Task currentTask = tasks.get(index);
            String name = currentTask.getName();
            tasks.remove(index);
            System.out.println(name + " is now removed.");
        }else{
            System.out.println("This number is not in the list");
        }
    }
        public void findTask(String nameOfTask) {
            boolean found = false;
            for (int index = 0; index < tasks.size(); index++) {
                Task currentTask = tasks.get(index);
                String priority = " -- Priority: " + currentTask.getPriority();
                if (currentTask.getName().toLowerCase().contains(nameOfTask.toLowerCase())) {
                    found = true;
                    System.out.println(currentTask.getName() + priority + " -- is found.");
                }
            }if (!found) {
                System.out.println("This name is not found the list");
            }
        }

    public void removeTaskByName(String nameOfTask) {

        for(int index = 0; index < tasks.size(); index++){
            Task currentTask = tasks.get(index);
            if(currentTask.getName().toLowerCase().contains(nameOfTask.toLowerCase())){
                tasks.remove(index);
                System.out.println(currentTask.getName() + ": Is now removed");
                return;
            }
        }
            System.out.println(nameOfTask + ": Is not found. The task is not removed");
    }

}

