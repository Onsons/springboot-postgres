package backend.backend.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.model.Employee;
import backend.backend.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
    

    @Autowired
    private EmployeeRepository employeeRepository; 


    @GetMapping("/employees")
    private List<Employee> getAllEmployees () {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    private Employee saveEmployee(@RequestBody  Employee e) {
        Employee employeeToSave  = new Employee();
        employeeToSave.setFirstName(e.getFirstName());
        employeeToSave.setLastName(e.getLastName());
        employeeToSave.setEmail(e.getEmail());
        return employeeRepository.save(e);
    }

    @DeleteMapping("/employees/{id}")
    private String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);;
        return " Employee Deleted Sucessfully";
    }
    

}
