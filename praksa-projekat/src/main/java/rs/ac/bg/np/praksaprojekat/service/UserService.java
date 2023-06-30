package rs.ac.bg.np.praksaprojekat.service;

import org.springframework.http.ResponseEntity;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.userUtil.PasswordChangePayload;

public interface UserService {
    public void init();

    User changePasswordOf(PasswordChangePayload payload) throws IllegalAccessException;

    User editUser(long id, User userForEdit);

    User createNewUser(User user);
}
