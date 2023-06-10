package rs.ac.bg.np.praksaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.np.praksaprojekat.domain.TimeOff;

@Repository
public interface TimeOffRepository extends JpaRepository<TimeOff,Long> {
}
