package example.controller;


import example.Dto.UserDto;
import example.entity.User;
import example.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//giving information in swagger
@Tag(

        name = "Crud Rest API for doing data base related operations",
        description = "Crud Rest API"
)
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

    //giving swagger information
    @Tag(
            name = "API to create information in db",
            description = "To create particular user and save it in db"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Tag(
            name = "API to fetch information from db based on id",
            description = "To get information from database based on id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto getUserInformation= userService.getUser(userId);
        return new ResponseEntity<>(getUserInformation, HttpStatus.OK);
    }

    @Tag(
            name = "API to update information in db",
            description = "To update information to db based on id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody @Valid User user){
        user.setId(id);
        UserDto userupdated = userService.updateUser(user);
        return new ResponseEntity<>(userupdated,HttpStatus.OK);
    }


    @Tag(
            name = "API to get information about all users",
            description = "To get all the information about all users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers= userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @Tag(
            name = "API to delete information by id",
            description = "to delete a particular user by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
       userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

}
