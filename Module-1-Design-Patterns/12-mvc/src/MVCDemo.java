// MVCDemo.java
// Demonstrates the Model-View-Controller (MVC) architectural pattern.
// Model holds data, View displays data, Controller connects the two.

// MODEL - pure data + business rules, no knowledge of the UI.
class Student {
    private String name;
    private String rollNo;

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }
}

// VIEW - only responsible for displaying data, has NO business logic.
class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

// CONTROLLER - connects Model and View; handles user actions.
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

    public String getStudentName() {
        return model.getName();
    }

    // Tells the View to render the CURRENT state of the Model.
    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

public class MVCDemo {
    public static void main(String[] args) {
        // Create the Model with initial data (this would normally come from a database)
        Student studentModel = new Student("Priya", "101");

        // Create the View
        StudentView view = new StudentView();

        // Controller wires Model and View together
        StudentController controller = new StudentController(studentModel, view);
        controller.updateView();

        // Simulate a user action: update the student's name via the controller
        System.out.println("--- After update ---");
        controller.setStudentName("Priya Sharma");
        controller.updateView();
    }
}
