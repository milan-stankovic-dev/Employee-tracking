package rs.ac.bg.np.praksaprojekat.service;

import rs.ac.bg.np.praksaprojekat.domain.User;

public interface UserService {
    User loadUserByUsername(String username);
}
