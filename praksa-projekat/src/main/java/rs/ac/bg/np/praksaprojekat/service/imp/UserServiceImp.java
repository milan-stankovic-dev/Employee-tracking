package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.domain.Role;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.repository.UserRepository;
import rs.ac.bg.np.praksaprojekat.service.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void init() {
        User user=new User();
        user.setEmail("admin");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
