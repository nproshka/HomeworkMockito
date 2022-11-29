package sky.pro.homeworkmockito.model;


import java.util.Objects;

public class Employee {

    public static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int dept;
    private final double salary;

    public Employee(String firstName, String lastName, int dept, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary = salary;
        this.id = counter++;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
