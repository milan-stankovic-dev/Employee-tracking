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
        System.out.println(user.getEmail());
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .admin(user.getRole().equals(Role.ADMIN))
                .build();
    }

    public AuthenticationResponse register(AuthenticationRequest request) {
        var user=User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);

        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .admin(user.getRole() == Role.ADMIN)
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse login (AuthenticationRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .admin(user.getRole()==Role.ADMIN)
                .build();
    }
}
