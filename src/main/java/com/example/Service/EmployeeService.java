package com.example.Service;

import com.example.Repository.EmployeeRepository;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  @Autowired
    EmployeeRepository employeeRepository;

 public Employee saveEmployee(Employee employee)
 {
     employeeRepository.save(employee) ;
     return employee;
 }

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList =   employeeRepository.findAll() ;
        return employeeList;
    }

    public  Optional<Employee> getEmployeeById(Long id){
        Optional<Employee> employee =   employeeRepository.findById(id) ;
        return employee;
    }
    public  String deleteEmployeeById(Long id){

       // Optional<Employee> employee =   employeeRepository.findById(id) ;
        List<Employee> employeeList =   employeeRepository.findAll() ;
        for (Employee employee : employeeList) {
            if(employee.getId().equals(id)){
                employeeRepository.delete(employee);
                return "Employee deleted";
            }

        }
        return null;
    }
}
