package rs.ac.bg.np.praksaprojekat.service.imp;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.EmployeeType;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    
    public void init() {
    	var employeeTypes = new ArrayList<EmployeeType>();
    	employeeTypes.add(new EmployeeType(0L,"frontend", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"backend", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"management", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"fullstack", new HashSet<Employee>()));
    	
    	employeeTypeRepository.saveAll(employeeTypes);
    }
}
