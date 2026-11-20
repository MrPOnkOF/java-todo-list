public class Task {
    private String name;
    private boolean completed;
    private Priority priority;

    public Task(String name, Priority priority) {
        this.name = name;
        this.completed = false;
        this.priority = priority;
    }
    public String getName() {
        return name;
    }
    public boolean isCompleted() {
        return completed;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
