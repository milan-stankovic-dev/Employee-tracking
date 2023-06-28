package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.np.praksaprojekat.domain.EmployeeType;

import rs.ac.bg.np.praksaprojekat.service.imp.EmployeeTypeServiceImp;

@RestController
@RequestMapping("/api/employee-type")
public class EmployeeTypeController {



    @Autowired
    private EmployeeTypeServiceImp employeeTypeService;

    @PostMapping("/{type}")
    public EmployeeType createNewEmployeeType(@PathVariable String type) throws Exception {
        return employeeTypeService.createNewEmployeeType(type);

    }

}
