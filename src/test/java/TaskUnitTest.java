import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskUnitTest {
    @Test
    public void newTaskShouldNotBeCompleted(){
        Task task = new Task("Learn Java", Priority.HIGH);
        assertFalse(task.isCompleted());
    }
    @Test
    public void newTaskShouldHaveCorrectPriority(){
        Task task = new Task("Learn SQL", Priority.MEDIUM);
        assertEquals(Priority.MEDIUM, task.getPriority());
    }
    @Test
    public void taskShouldBeCompleted(){
        Task task = new Task("Learn Java", Priority.MEDIUM);
        task.setCompleted(true);
        assertTrue(task.isCompleted());
    }
}
