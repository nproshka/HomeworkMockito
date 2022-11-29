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

@ExtendWith(MockitoExtension.class)
public class DepartamentSerivceTest {

    private final Employee employee1 = new Employee("Евгений", "Алексеев", 1, 23500.0);
    private final Employee employee2 = new Employee("Алексей", "Алексеев", 1, 50000.0);
    private final Employee employee3 = new Employee("Петр", "Алексеев", 2, 43500.0);
    private final Employee employee4 = new Employee("Андрей", "Петров", 2, 27000.0);
    private final Employee employeeDeptZero = new Employee("Алексей", "Федоров", 0, 55000.0);

    @Mock
    private EmployeeService employeeService;

    private DepartmentService departmentService;



//    @BeforeEach
//    public void SetUp() {
//        map1.put(employee1.getId(), employee1);
//        map1.put(employee2.getId(), employee2);
//        map1.put(employee3.getId(), employee3);
//        map1.put(employee4.getId(), employee4);
//    }

    @Test
    public void getEmployeeListOfDeptTest1() {
        Map<Integer, Employee> map2 = new HashMap<>();
        map2.put(employee1.getId(), employee1);
        map2.put(employee2.getId(), employee2);
//        map2.put(employee3.getId(), employee3);
//        map2.put(employee4.getId(), employee4);
        Mockito.when(employeeService.getEmployees()).thenReturn(map2);

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));


        assertEquals(employeeService.getEmployees(), departmentService.getEmployeeListOfDept(1));
        //Я не понимаю почему возвращается что this.departmentService is Null хотя я, используя Москито, перопределил что getEmployees возращает map1 и метод должен сработать


    }

    @Test
    public void getSalarySumOfDeptTest1() {

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

    }

    @Test
    public void getMaxSalaryOfDeptTest() {

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

    }

    @Test
    public void getMinSalaryOfDeptTest() {

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

    }

    @Test
    public void getMapOfEmployeesDividedOnDept() {

        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(0));
        Assertions.assertThrows(RuntimeException.class, () -> departmentService.getEmployeeListOfDept(6));

    }

}
