package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

}
