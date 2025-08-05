package Week1.AlgorithmsDataStructure;

class Task {
    String taskId;
    String taskName;
    String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ID: " + taskId + ", Task: " + taskName + ", Status: " + status;
    }
}

public class TaskManager {
    static Task head = null;

    public static void addTask(String id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println(" Added: " + name);
    }

    public static Task searchTask(String id) {
        Task current = head;
        while (current != null) {
            if (current.taskId.equalsIgnoreCase(id)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void deleteTask(String id) {
        if (head == null)
            return;

        if (head.taskId.equalsIgnoreCase(id)) {
            head = head.next;
            System.out.println(" Deleted Task with ID: " + id);
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId.equalsIgnoreCase(id)) {
                current.next = current.next.next;
                System.out.println(" Deleted Task with ID: " + id);
                return;
            }
            current = current.next;
        }

        System.out.println(" Task not found.");
    }

    public static void showAllTasks() {
        System.out.println(" Task List:");
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        addTask("T001", "Create UML Diagram", "Pending");
        addTask("T002", "Write Code", "In Progress");
        addTask("T003", "Test Application", "Pending");

        showAllTasks();

        System.out.println("🔍 Searching T002...");
        Task found = searchTask("T002");
        System.out.println(found != null ? " Found: " + found : " Not Found");

        System.out.println(" Deleting T001...");
        deleteTask("T001");

        showAllTasks();
    }
}
