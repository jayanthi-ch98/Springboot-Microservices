package example.controller;


import example.Dto.UserDto;
import example.entity.User;
import example.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
     private UserServiceImpl userService;

    //Creating a Restful API to save user information to database
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User savedUser= userService.createUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }

    //Refactoring Post method(creating UserDto class instead of user for Post class)
    //@Valid --> is used to add validations for Request
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto getUserInformation= userService.getUser(userId);
        return new ResponseEntity<>(getUserInformation, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody @Valid User user){
        user.setId(id);
        UserDto userupdated = userService.updateUser(user);
        return new ResponseEntity<>(userupdated,HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers= userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
       userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

}
