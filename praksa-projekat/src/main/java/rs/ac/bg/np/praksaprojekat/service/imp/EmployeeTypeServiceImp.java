package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.EmployeeType;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.EmployeeTypeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;


    public EmployeeType createNewEmployeeType(String newEmpType) throws Exception {

        Optional<EmployeeType> optionalEmployeeType = employeeTypeRepository.findByName(newEmpType);
        if(optionalEmployeeType.isPresent()){
            throw new Exception("This name of EmployeeType already exists!");

        }


        EmployeeType newTypeOfEmployee = new EmployeeType();
        newTypeOfEmployee.setName(newEmpType);

        employeeTypeRepository.save(newTypeOfEmployee);


        return newTypeOfEmployee;
    }
    
    public void init() {
    	var employeeTypes = new ArrayList<EmployeeType>();
    	employeeTypes.add(new EmployeeType(0L,"frontend", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"backend", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"management", new HashSet<Employee>()));
    	employeeTypes.add(new EmployeeType(0L,"fullstack", new HashSet<Employee>()));

        var employeeTypesListFromDb = employeeTypeRepository.findAll();
        boolean exists = employeeTypesListFromDb.stream().allMatch(employeeTypes::contains);

        if(!exists) {
            employeeTypeRepository.saveAll(employeeTypes);
        }
    }

}
