package rs.ac.bg.np.praksaprojekat.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.np.praksaprojekat.config.JwtService;
import rs.ac.bg.np.praksaprojekat.domain.Role;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.repository.UserRepository;


@Service
public class AuthenticationService {

    @Autowired
    private  AuthenticationManager authenticationManager;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .isAdmin(user.getRole().equals(Role.ADMIN))
                .build();
    }

}
