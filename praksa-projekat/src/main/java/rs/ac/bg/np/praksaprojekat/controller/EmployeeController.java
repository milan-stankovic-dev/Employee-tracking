package rs.ac.bg.np.praksaprojekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.insert(employee));
    }
    
    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(){
    	return ResponseEntity.ok(employeeService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id){
    	return ResponseEntity.ok(employeeService.getById(id));
    }
}
