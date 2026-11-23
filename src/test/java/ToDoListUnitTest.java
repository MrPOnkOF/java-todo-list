import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListUnitTest {
    @Test
    public void shouldRejectEmptyTaskName(){
        ToDoList toDoList = new ToDoList();
        assertThrows(IllegalArgumentException.class, () -> {
            toDoList.addTask("", Priority.HIGH);
        });
    }
    @Test
    public void shouldRejectBlankTaskName(){
        ToDoList toDoList = new ToDoList();
        assertThrows(IllegalArgumentException.class, () -> {
            toDoList.addTask("  ", Priority.LOW);
        });
    }
    @Test
    public void shouldRejectNullTaskName(){
        ToDoList toDoList = new ToDoList();
        assertThrows(IllegalArgumentException.class, () -> {
            toDoList.addTask(null, Priority.LOW);
        });
    }
    @Test
    public void shouldAcceptValidTaskName(){
        ToDoList toDoList = new ToDoList();
        assertDoesNotThrow(() -> {
            toDoList.addTask("Learn Java", Priority.HIGH);
        });
    }
    @Test
    public void shouldIncreaseTaskCounterAfterAddingTask(){
        ToDoList toDoList = new ToDoList();
        int initialCount = toDoList.getTaskCount();
        toDoList.addTask("Learn Spring Boot", Priority.HIGH);
        assertEquals(initialCount + 1, toDoList.getTaskCount());
    }
    @Test
    public void shouldDecreaseTaskCounterAfterRemovingTask(){
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Learn Java", Priority.HIGH);
        int initialCount = toDoList.getTaskCount();
        toDoList.removeTask(1);
        assertEquals(initialCount - 1, toDoList.getTaskCount());
    }
    @Test
    public void shouldNotRemoveTaskWithInvalidNumber(){
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Learn Java", Priority.HIGH);
        toDoList.addTask("Learn SQL", Priority.MEDIUM);
        int initialCount = toDoList.getTaskCount();
        toDoList.removeTask(99);
        assertEquals(2, initialCount);
    }
    @Test
    public void shouldRemoveTaskByName(){
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Learn Java", Priority.HIGH);
        toDoList.addTask("Learn SQL", Priority.HIGH);
        int initialCount = toDoList.getTaskCount();
        toDoList.removeTaskByName("Learn Java");
        assertEquals(initialCount - 1, toDoList.getTaskCount());
    }
    @Test
    public void shouldKeepCorrectTaskAfterRemoval(){
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Learn Java", Priority.HIGH);
        toDoList.addTask("Learn SQL", Priority.MEDIUM);
        toDoList.removeTaskByName("Learn Java");
        assertEquals("Learn SQL",  toDoList.getTask(1).getName());

    }
    private ToDoList toDoList;
    @BeforeEach
    public void setUp(){
        this.toDoList = new ToDoList();
    }
    @Test
    public void shouldThrowExceptionForInvalidTaskNumber(){
        toDoList.addTask("Learn Java", Priority.HIGH);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            toDoList.getTask(5);
        });
    }
    @Test
    public void shouldStartWithEmptyList(){
        assertEquals(0, toDoList.getTaskCount());
    }


}
