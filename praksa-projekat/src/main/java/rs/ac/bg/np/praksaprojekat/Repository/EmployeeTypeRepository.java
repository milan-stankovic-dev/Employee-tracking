package rs.ac.bg.np.praksaprojekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository <EmployeeTypeRepository,Long>{
}
