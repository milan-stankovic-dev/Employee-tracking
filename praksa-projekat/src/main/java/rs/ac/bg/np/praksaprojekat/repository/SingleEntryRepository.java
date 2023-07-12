package rs.ac.bg.np.praksaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.np.praksaprojekat.domain.SingleEntry;

import java.util.List;

@Repository
public interface SingleEntryRepository extends JpaRepository<SingleEntry,Long> {
    List<SingleEntry> findAllByEmployeeEntryId(long id);
}
