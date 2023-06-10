package rs.ac.bg.np.praksaprojekat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.np.praksaprojekat.domain.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
