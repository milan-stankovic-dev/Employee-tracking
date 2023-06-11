package rs.ac.bg.np.praksaprojekat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.repository.UserRepository;
import rs.ac.bg.np.praksaprojekat.service.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
