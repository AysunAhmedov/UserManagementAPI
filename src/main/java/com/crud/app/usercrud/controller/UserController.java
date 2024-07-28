package com.crud.app.usercrud.controller;

import com.crud.app.usercrud.config.Descriptions;
import com.crud.app.usercrud.exception.ApiResponse;
import com.crud.app.usercrud.dto.UserDTO;
import com.crud.app.usercrud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "User managing API")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users", description = Descriptions.GET_USERS)
    @GetMapping
    public List<UserDTO> getUsers(@RequestParam(defaultValue =  "0") int pageNo ,@RequestParam(defaultValue =  "10") int pageSize,@RequestParam(required = false) String searchTerm)
    {
        return userService.getUsers(pageNo,pageSize,searchTerm);
    }

    @Operation(summary = "Get user by ID",description = Descriptions.GET_USER_BY_ID)
    @GetMapping(value = "/{id}")
    public ResponseEntity <UserDTO>  getById(@Parameter(description = "The unique ID of the user to retrieve") @PathVariable Long id)
    {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(userDTO) ;
    }

    @Operation(summary = "Create a user" , description = Descriptions.CREATE_USER)
    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {

        return userService.createUser(userDTO);
    }

    @Operation(summary = "Update user by ID",description = Descriptions.UPDATE_USER)
    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@Parameter(description = "The unique ID of the user to update") @PathVariable Long id ,@Valid @RequestBody UserDTO user) {

        return userService.updateUser(id,user);
    }

    @Operation(summary = "Delete user by ID",description = Descriptions.DELETE_USER)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@Parameter(description = "The unique ID of the user to retrieve") @PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
