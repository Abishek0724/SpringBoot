package com.example.demo;



import jakarta.persistence.*;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String department;

    public Employee(long l, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

