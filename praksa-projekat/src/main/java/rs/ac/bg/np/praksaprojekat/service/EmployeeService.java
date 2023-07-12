package rs.ac.bg.np.praksaprojekat.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import rs.ac.bg.np.praksaprojekat.domain.Employee;

public interface EmployeeService {
    public Employee insert(Employee employee) throws EntityNotFoundException;

	public List<Employee> getAll();

	public Employee getById(long id);
}
