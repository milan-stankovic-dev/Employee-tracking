package rs.ac.bg.np.praksaprojekat.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.config.JwtService;
import rs.ac.bg.np.praksaprojekat.domain.Role;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.exception.UserNotLoggedInException;
import rs.ac.bg.np.praksaprojekat.exception.WrongValueProvidedException;
import rs.ac.bg.np.praksaprojekat.repository.UserRepository;
import rs.ac.bg.np.praksaprojekat.service.UserService;
import rs.ac.bg.np.praksaprojekat.userUtil.PasswordChangePayload;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public void init() {
        User user = new User();
        user.setEmail("admin");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }

    @Override
    public User changePasswordOf(PasswordChangePayload payload)
            throws IllegalAccessException {

        var userOptional = userRepository.findByEmail(payload.email());

        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("There is no user with given username.");
        }

        User userFromDB = userOptional.get();

        if (!userFromDB.getPassword().equals(payload.oldPassword())) {
            throw new WrongValueProvidedException("The password provided does not" +
                    "match the one in the database.");
        }

        if (userFromDB.getPassword().equals(payload.newPassword())) {
            throw new IllegalArgumentException("The password you provided for change " +
                    "must be different from the old password.");
        }

        long loggedInUserID = getLoggedInUserId();

        if (loggedInUserID != userFromDB.getId()) {
            throw new IllegalAccessException("You are not authorized to change " +
                    "this user's password.");
        }

        userFromDB.setPassword(payload.newPassword());
        return userRepository.save(userFromDB);
    }

    private long getLoggedInUserId() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UserNotLoggedInException("Please log in to perform" +
                    " this action.");
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            long currentUserId = ((User) principal).getId();

            return currentUserId;
        }
        throw new IllegalStateException("Something went wrong while " +
                "fetching security context for user");
    }
}
