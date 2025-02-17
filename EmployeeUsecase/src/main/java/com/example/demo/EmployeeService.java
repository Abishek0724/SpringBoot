package com.example.demo;



import com.example.demo.EmployeeRequest;
import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeRequest request) {
        Employee employee = new Employee(0, null, null, null);
        employee.setName(request.getName());

        // Ensure only valid roles are assigned
        switch (request.getRole().toLowerCase()) {
            case "developer":
                employee.setRole("Developer");
                break;
            case "tester":
                employee.setRole("Tester");
                break;
            case "architect":
                employee.setRole("Architect");
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + request.getRole());
        }

        employee.setDepartment(request.getDepartment());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

