package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.domain.EmployeeType;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.EmployeeTypeService;

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


}
