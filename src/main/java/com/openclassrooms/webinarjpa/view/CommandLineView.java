package com.openclassrooms.webinarjpa.view;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.openclassrooms.webinarjpa.model.Department;
import com.openclassrooms.webinarjpa.model.Employee;
import com.openclassrooms.webinarjpa.model.Project;
import com.openclassrooms.webinarjpa.repository.DepartmentRepository;
import com.openclassrooms.webinarjpa.repository.EmployeeRepository;
import com.openclassrooms.webinarjpa.repository.ProjectRepository;

@Component
public class CommandLineView implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
		
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome - Let's go for some database operations");
		
		System.out.println("-- Read operations");		
		Iterable<Employee> employees = employeeRepository.findAll();
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			Employee e = iterator.next();
			StringBuilder sb = new StringBuilder();
			sb.append("ID : " + e.getEmployeeID());
			sb.append(", Lastname : " + e.getLastName());
			sb.append(", Department name : " + e.getDepartment().getName());
			sb.append(", Projects : ");
			for(Project p : e.getProjects()) {
				sb.append(p.getName() + " ");
			}
			System.out.println(sb.toString());
		}
		
		System.out.println("-- Create operations");
		Department newDepartment = new Department();
		newDepartment.setName("HR");
		newDepartment = departmentRepository.save(newDepartment);
		
		Employee newEmployee = new Employee();
		newEmployee.setEmployeeNumber(4321);
		newEmployee.setLastName("dupont");
		newEmployee.setFirstName("Antoine");
		newEmployee.setEmail("antoine.dupont@firm.com");
		newEmployee.setPhoneNumber("+33698765432");
		newEmployee.setHireDate(new Date());
		newEmployee.setDepartment(newDepartment);
		
		Project newProject = new Project();
		newProject.setName("HRProject");
		newProject.setDescription("The ultimate HR project !");

		newEmployee.getProjects().add(newProject);
		newEmployee = employeeRepository.save(newEmployee);
		
		
		System.out.println("-- Update operations");
		Project existingProject = projectRepository.findById(1).get();
		existingProject.setName("newProjectName");
		projectRepository.save(existingProject);
		
		
		System.out.println("-- Delete operations");
		employeeRepository.delete(newEmployee);
		departmentRepository.delete(newDepartment);
		
	}

}
