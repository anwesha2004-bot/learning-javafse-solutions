package Week1.DesignPatterns;

class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("📚 Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }
}

// Controller
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Main class
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create model and view
        Student student = new Student("Anwesha Mitra", "UEM2025", "A+");
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update student info
        controller.setStudentName("Anwesha M.");
        controller.setStudentGrade("A");
        controller.updateView();
    }
}
