package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.service.EmployeeTypeService;

@RestController
@RequestMapping("/api/employee-type")
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;
}
