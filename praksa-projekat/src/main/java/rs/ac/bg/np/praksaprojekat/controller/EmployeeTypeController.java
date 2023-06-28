package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/newEmpType")
    public EmployeeType createNewEmployeeType(String newEmpType) throws Exception {
        return employeeTypeService.createNewEmployeeType(newEmpType);

    }

}
