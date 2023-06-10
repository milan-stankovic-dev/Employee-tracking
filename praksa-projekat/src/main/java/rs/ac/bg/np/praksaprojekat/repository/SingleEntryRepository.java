package rs.ac.bg.np.praksaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleEntryRepository extends JpaRepository<SingleEntryRepository,Long> {
}
