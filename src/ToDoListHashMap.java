import java.util.HashMap;

public class ToDoListHashMap {

    HashMap<Integer, String> tasksMap = new HashMap<>();

    public void addDefTask(){
        tasksMap.put(1, "Learn Java");
    }

    public void addDefaultTasksHashMap(Integer num, String task) {
        tasksMap.put(num, task);
        tasksMap.put(101, "Learn Java");
    }

    public void findTaskById(int id){
        if(tasksMap.containsKey(id)) {
            System.out.println(tasksMap.get(id));
        }else{
            System.out.println("No tasks with such ID");
        }
    }
}
