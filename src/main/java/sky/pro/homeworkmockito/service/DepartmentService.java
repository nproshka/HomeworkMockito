package sky.pro.homeworkmockito.service;

import org.springframework.stereotype.Service;
import sky.pro.homeworkmockito.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, Employee> getEmployeeListOfDept(int dept) {
        if(dept == 0 || dept >=6) {
            throw new RuntimeException("Введите корректный номер отдела!");
        }
        //В нашей системе есть только 5 отделов
        Map<Integer, Employee> map1 = new HashMap<>();
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDept() == dept) {
                map1.put(entry.getKey(), entry.getValue());
            }
        }
        return map1;
    }
    public double getSalarySumOfDept(int dept) {
        if(dept == 0 || dept >=6) {
            throw new RuntimeException("Введите корректный номер отдела!");
        }
        double salarySum = 0.0;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDept() == dept) {
                salarySum = salarySum + entry.getValue().getSalary();
            }
        }
        return salarySum;
    }
    public double getMaxSalaryOfDept(int dept) {
        if(dept == 0 || dept >=6) {
            throw new RuntimeException("Введите корректный номер отдела!");
        }
        double maxSalary = Double.MIN_VALUE;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getSalary() > maxSalary && entry.getValue().getDept() == dept) {
                maxSalary = entry.getValue().getSalary();
            }
        }
        return maxSalary;
    }
    public double getMinSalaryOfDept(int dept) {
        if(dept == 0 || dept >=6) {
            throw new RuntimeException("Введите корректный номер отдела!");
        }
        double minSalary = Double.MAX_VALUE;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getSalary() < minSalary && entry.getValue().getDept() == dept) {
                minSalary = entry.getValue().getSalary();
            }
        }
        return minSalary;
    }

    public Map<Integer, Employee> getMapOfEmployeesDividedOnDept() {
        Map<Integer, Employee> map = new HashMap<>();
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            map.put(entry.getValue().getDept(), entry.getValue());
        }
        return map;
    }

}
