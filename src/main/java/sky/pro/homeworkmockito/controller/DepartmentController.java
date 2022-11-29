package sky.pro.homeworkmockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.homeworkmockito.model.Employee;
import sky.pro.homeworkmockito.service.DepartmentService;

import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, Employee> getEmployeeListOfDept(int dept) {
        return departmentService.getEmployeeListOfDept(dept);
    }
    @GetMapping("/salary/sum")
    public double getSalarySumOfDept(int dept) {
        return departmentService.getSalarySumOfDept(dept);
    }
    @GetMapping("/salary/max")
    public double getMaxSalaryOfDept(int dept) {
        return departmentService.getMaxSalaryOfDept(dept);
    }
    @GetMapping("/salary/min")
    public double getMinSalaryOfDept(int dept) {
        return departmentService.getMinSalaryOfDept(dept);
    }
    @GetMapping("/employees/group")
    public Map<Integer, Employee> getEmployeeListOfDept() {
        return departmentService.getMapOfEmployeesDividedOnDept();
    }
}
