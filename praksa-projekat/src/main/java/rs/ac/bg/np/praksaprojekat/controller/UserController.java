package rs.ac.bg.np.praksaprojekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.np.praksaprojekat.domain.User;
import rs.ac.bg.np.praksaprojekat.service.UserService;
import rs.ac.bg.np.praksaprojekat.userUtil.PasswordChangePayload;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }


    @PutMapping("/password-change")
    public ResponseEntity<Object> changePassword(
            @RequestBody PasswordChangePayload payload){
        try{
            return ResponseEntity.ok(userService.changePasswordOf(payload));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }
    @PutMapping("/{userId}/password-change")
    public ResponseEntity<Object> changePasswordNew(
            @PathVariable Long userId,
            @RequestBody String newPassword
    ){
        try {
            return ResponseEntity.ok(userService.changePasswordNew(userId,newPassword));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

    @PutMapping("/edit-user/{id}")
    public ResponseEntity<Object> editUser(
            @RequestBody User userForEdit,
            @PathVariable long id) {
        try{
            return ResponseEntity.ok(userService.editUser(id, userForEdit));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }
}
