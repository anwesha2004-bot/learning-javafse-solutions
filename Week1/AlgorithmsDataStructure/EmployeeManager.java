package Week1.AlgorithmsDataStructure;

class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: Rs" + salary;
    }
}

public class EmployeeManager {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = e;
            System.out.println(" Added: " + e.name);
        } else {
            System.out.println(" Employee list full.");
        }
    }

    public static Employee searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equalsIgnoreCase(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public static void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equalsIgnoreCase(id)) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println(" Deleted Employee with ID: " + id);
                return;
            }
        }
        System.out.println(" Employee not found.");
    }

    public static void showAllEmployees() {
        System.out.println(" Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        addEmployee(new Employee("E101", "Anwesha", "Developer", 55000));
        addEmployee(new Employee("E102", "Ritik", "Designer", 50000));
        addEmployee(new Employee("E103", "Debonita", "Manager", 75000));
        showAllEmployees();

        System.out.println("🔍 Searching E102...");
        Employee e = searchEmployee("E102");
        System.out.println(e != null ? " Found: " + e : " Not found");

        System.out.println(" Deleting E101...");
        deleteEmployee("E101");

        showAllEmployees();
    }
}
