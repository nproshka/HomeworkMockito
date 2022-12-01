package sky.pro.homeworkmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sky.pro.homeworkmockito.model.Employee;
import sky.pro.homeworkmockito.record.EmployeeRequest;
import sky.pro.homeworkmockito.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class EmployeeServiceTest {
    private final EmployeeRequest employee1 = new EmployeeRequest("Евгений", "Алексеев", 1, 23500.0);
    private final EmployeeRequest employee1_2 = new EmployeeRequest("Евгений", "Алексеев", 1, 23500.0);
    private final EmployeeRequest employee2 = new EmployeeRequest("Евгений", "Алексеев", 1, 43500.0);
    private final EmployeeRequest employee3 = new EmployeeRequest("Алексей", "Федоров", 2, 55000.0);
    private final EmployeeRequest nullEmployee4 = new EmployeeRequest(null, "Андреев", 2, 25000.0);
    private final EmployeeRequest nullEmployee5 = new EmployeeRequest("Пётр", null, 2, 100000.0);

    EmployeeService employeeService = new EmployeeService();

    @Test
    public void addEmployeeTest() {

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee1_2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(nullEmployee4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> employeeService.addEmployee(nullEmployee5));

    }
    @Test
    public void getSalarySumTest() {

        double salary = 0.0;

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);


        Map<Integer, EmployeeRequest> map1 = new HashMap<>();
        map1.put(0, employee1);
        map1.put(1, employee2);

        for (Map.Entry<Integer, EmployeeRequest> entry : map1.entrySet()) {
            salary = salary + entry.getValue().getSalary();
        }

        assertEquals(employeeService.getSalarySum(), salary);

    }

    @Test
    public void getMinSalaryEmployeeTest() {

        double salary = 0.0;
        double minSalary = Double.MAX_VALUE;
        EmployeeRequest e = null;

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);


        Map<Integer, EmployeeRequest> map1 = new HashMap<>();
        map1.put(4, employee1);
        map1.put(1, employee2);

        for (Map.Entry<Integer, EmployeeRequest> entry : map1.entrySet()) {
            if (entry.getValue().getSalary() < minSalary) {
                minSalary = entry.getValue().getSalary();
                e = entry.getValue();
            }
        }

        assertEquals(employeeService.getMinSalaryEmployee().getSalary(), e.getSalary());


    }
    @Test
    public void getMaxSalaryEmployeeTest() {

        double salary = 0.0;
        double maxSalary = Double.MIN_VALUE;
        int e = 10;

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);


        Map<Integer, EmployeeRequest> map1 = new HashMap<>();
        map1.put(0, employee1);
        map1.put(1, employee2);

        for (Map.Entry<Integer, EmployeeRequest> entry : map1.entrySet()) {
            if (entry.getValue().getSalary() > maxSalary) {
                maxSalary = entry.getValue().getSalary();
                e = entry.getKey();
            }
        }

        assertEquals(employeeService.getMaxSalaryEmployee().getId(), e);


    }


}
