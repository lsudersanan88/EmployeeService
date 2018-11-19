package com.example.Controller;

import com.example.Service.EmployeeService;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

  @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
     if(employee!= null)
     {
         employee = employeeService.saveEmployee(employee);

       return new ResponseEntity(employee.getId(),HttpStatus.OK);
     }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

    @GetMapping("/employee/getAll")
    public ResponseEntity<List<Employee>> getEmployees()
    {

           List<Employee> employees = employeeService.getAllEmployees();
        if(employees.size()!=0)
        {
            return new ResponseEntity<>(employees,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/employee/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
    {

      Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee != null)
        {
            return new ResponseEntity(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteByEmployeeById(@PathVariable("id") Long id)
    {

        String string = employeeService.deleteEmployeeById(id);
        if(string != null)
        {
            return new ResponseEntity(string,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/employee/save")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id)
    {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee != null)
        {
            return new ResponseEntity(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
