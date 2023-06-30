package rs.ac.bg.np.praksaprojekat.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.domain.Employee;
import rs.ac.bg.np.praksaprojekat.domain.EmployeeType;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeRepository;
import rs.ac.bg.np.praksaprojekat.repository.EmployeeTypeRepository;
import rs.ac.bg.np.praksaprojekat.service.EmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public Employee insert(Employee employee) throws EntityNotFoundException {
       Optional<EmployeeType> employeeType=employeeTypeRepository.findByName("frontend");
       if(!employeeType.isPresent()){
           throw new EntityNotFoundException("EmployeeType with this name does not exist!");
       }
       employee.setEmployeeType(employeeType.get());
       employeeRepository.save(employee);
       return employee;
    }
}
