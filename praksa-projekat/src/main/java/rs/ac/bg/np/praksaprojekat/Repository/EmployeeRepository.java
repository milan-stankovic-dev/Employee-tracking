package rs.ac.bg.np.praksaprojekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.np.praksaprojekat.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
