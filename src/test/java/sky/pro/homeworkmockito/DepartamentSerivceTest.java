package sky.pro.homeworkmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.homeworkmockito.model.Employee;
import sky.pro.homeworkmockito.record.EmployeeRequest;
import sky.pro.homeworkmockito.service.DepartmentService;
import sky.pro.homeworkmockito.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class DepartamentSerivceTest {

    private final Employee employee1Dept1 = new Employee("Евгений", "Алексеев", 1, 23500.0);
    private final Employee employee2Dept1 = new Employee("Алексей", "Алексеев", 1, 50000.0);
    private final Employee employee3Dept2 = new Employee("Петр", "Алексеев", 2, 43500.0);
    private final Employee employee4Dept2 = new Employee("Андрей", "Петров", 2, 27000.0);

    @Mock
    private EmployeeService employeeService;

    private DepartmentService departmentService;

    private Map<Integer, Employee> map2 = new HashMap<>();

    @BeforeEach
    public void SetUp() {
        departmentService = new DepartmentService(employeeService);
    }

    @Test
    public void getEmployeeListOfDeptTest1() {
        map2.put(employee1Dept1.getId(), employee1Dept1);
        map2.put(employee2Dept1.getId(), employee2Dept1);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

        assertEquals(employeeService.getEmployees(), departmentService.getEmployeeListOfDept(1));

    }

    @Test
    public void getSalarySumOfDeptTest1() {
        map2.put(employee1Dept1.getId(), employee1Dept1);
        map2.put(employee2Dept1.getId(), employee2Dept1);
        map2.put(employee3Dept2.getId(), employee3Dept2);
        map2.put(employee4Dept2.getId(), employee4Dept2);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

        double salarySumDept1 = employee1Dept1.getSalary() + employee2Dept1.getSalary();
        double salarySumDept2 = employee3Dept2.getSalary() + employee4Dept2.getSalary();

        assertEquals(salarySumDept1, departmentService.getSalarySumOfDept(1));
        assertEquals(salarySumDept2, departmentService.getSalarySumOfDept(2));

    }

    @Test
    public void getMaxSalaryOfDeptTest() {
        map2.put(employee1Dept1.getId(), employee1Dept1);
        map2.put(employee2Dept1.getId(), employee2Dept1);
        map2.put(employee3Dept2.getId(), employee3Dept2);
        map2.put(employee4Dept2.getId(), employee4Dept2);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        double maxSalaryOfDept1 = employee2Dept1.getSalary();
        double maxSalaryOfDept2 = employee3Dept2.getSalary();

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

        assertEquals(maxSalaryOfDept1, departmentService.getMaxSalaryOfDept(1));
        assertEquals(maxSalaryOfDept2, departmentService.getMaxSalaryOfDept(2));

    }

    @Test
    public void getMinSalaryOfDeptTest() {
        map2.put(employee1Dept1.getId(), employee1Dept1);
        map2.put(employee2Dept1.getId(), employee2Dept1);
        map2.put(employee3Dept2.getId(), employee3Dept2);
        map2.put(employee4Dept2.getId(), employee4Dept2);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        double minSalaryOfDept1 = employee1Dept1.getSalary();
        double minSalaryOfDept2 = employee4Dept2.getSalary();

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

        assertEquals(minSalaryOfDept1, departmentService.getMinSalaryOfDept(1));
        assertEquals(minSalaryOfDept2, departmentService.getMinSalaryOfDept(2));

    }

    @Test
    public void getMapOfEmployeesDividedOnDept() {
        map2.put(employee1Dept1.getId(), employee1Dept1);
        map2.put(employee2Dept1.getId(), employee2Dept1);
        map2.put(employee3Dept2.getId(), employee3Dept2);
        map2.put(employee4Dept2.getId(), employee4Dept2);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

        assertNotEquals(employeeService.getEmployees(), departmentService.getMapOfEmployeesDividedOnDept());

    }

}
