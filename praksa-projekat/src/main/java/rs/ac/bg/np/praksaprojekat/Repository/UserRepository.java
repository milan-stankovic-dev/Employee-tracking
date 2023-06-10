package rs.ac.bg.np.praksaprojekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.np.praksaprojekat.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
