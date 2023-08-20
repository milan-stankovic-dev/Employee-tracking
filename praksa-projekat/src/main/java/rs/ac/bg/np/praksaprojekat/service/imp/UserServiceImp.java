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
//import rs.ac.bg.np.praksaprojekat.exception.UsernameTakenException;
import rs.ac.bg.np.praksaprojekat.exception.UsernameTakenException;
import rs.ac.bg.np.praksaprojekat.exception.WrongValueProvidedException;
import rs.ac.bg.np.praksaprojekat.repository.UserRepository;
import rs.ac.bg.np.praksaprojekat.service.UserService;
import rs.ac.bg.np.praksaprojekat.userUtil.PasswordChangePayload;

import java.util.Optional;

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
        if(!userRepository.existsByEmailAndPassword(user.getEmail(),user.getPassword())){
            userRepository.save(user);
        }

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

    @Override
    public User editUser(long id, User userForEdit) {
        if(userForEdit == null){
            throw new NullPointerException("User cannot be null.");
        }
        Optional<User> usernameCheckFromDbUser = userRepository.findByEmail(
                userForEdit.getEmail()
        );

        if(usernameCheckFromDbUser.isPresent()){
            throw new UsernameTakenException("This username is taken.");
        }
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new EntityNotFoundException("There is no user with given id.");
        }
        User user = userOptional.get();
        user.setEmail(userForEdit.getEmail());
        user.setPassword(userForEdit.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User createNewUser(User user) {

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if(optionalUser.isPresent()){
            throw new EntityNotFoundException("This username already exists in App!");
        }
        user.setRole(Role.USER);

        return userRepository.save(user);

    }

    @Override
    public User changePasswordNew(Long userId, String newPassword) throws IllegalAccessException {
        Optional<User> optionalUser=userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new EntityNotFoundException("The user with this id does not exist!");
        }
        User user=optionalUser.get();

        long loggedInUserID = getLoggedInUserId();

        if (loggedInUserID != user.getId()) {
            throw new IllegalAccessException("You are not authorized to change " +
                    "this user's password.");
        }
        user.setPassword(newPassword);
        return userRepository.save(user);
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
