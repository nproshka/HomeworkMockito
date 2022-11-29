package sky.pro.homeworkmockito.record;

public class EmployeeRequest {

    private String firstName;
    private String lastName;
    private int dept;
    private double salary;

    public EmployeeRequest(String firstName, String lastName, int dept, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }
}
