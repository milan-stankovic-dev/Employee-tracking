package rs.ac.bg.np.praksaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.np.praksaprojekat.domain.TimeOff;
import rs.ac.bg.np.praksaprojekat.domain.TimeOffType;

@Repository
public interface TimeOffTypeRepository extends JpaRepository<TimeOffType,Long> {
}
