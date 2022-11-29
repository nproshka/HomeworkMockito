package sky.pro.homeworkmockito.service;

import org.springframework.stereotype.Service;
import sky.pro.homeworkmockito.model.Employee;
import sky.pro.homeworkmockito.record.EmployeeRequest;


import java.util.*;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public Collection<Employee> getAllEmployees () {
        return employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Введите Имя и Фамилию!");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDept(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }


    public double getSalarySum() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }

    public Employee getMinSalaryEmployee() {
        Employee e = null;
        double minSalary = Double.MAX_VALUE;
        for (Map.Entry<Integer, Employee> entry : this.employees.entrySet()) {
            if (entry.getValue().getSalary() < minSalary) {
                minSalary = entry.getValue().getSalary();
                e = entry.getValue();
            }
        }
        return e;
    }
    public Employee getMaxSalaryEmployee() {
        Employee e = null;
        double maxSalary = Double.MIN_VALUE;
        for (Map.Entry<Integer, Employee> entry : this.employees.entrySet()) {
            if (entry.getValue().getSalary() > maxSalary) {
                maxSalary = entry.getValue().getSalary();
                e = entry.getValue();
            }
        }
        return e;
    }



}
