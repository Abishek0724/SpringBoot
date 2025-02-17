package com.example.demo;



import com.example.demo.EmployeeRequest;
import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testAddEmployee() {
        EmployeeRequest request = new EmployeeRequest();
        request.setName("Alice");
        request.setRole("developer");
        request.setDepartment("IT");

        Employee employee = new Employee(1L, "Alice", "Developer", "IT");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.addEmployee(request);

        assertEquals("Developer", savedEmployee.getRole());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Collections.emptyList());

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(0, employees.size());
        verify(employeeRepository, times(1)).findAll();
    }
}
