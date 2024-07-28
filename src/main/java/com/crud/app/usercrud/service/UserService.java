package com.crud.app.usercrud.service;

import com.crud.app.usercrud.exception.ApiResponse;
import com.crud.app.usercrud.model.User;
import com.crud.app.usercrud.repository.UserRepo;
import com.crud.app.usercrud.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    private UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }




public List<UserDTO> getUsers(int pageNo ,int pageSize,String searchTerm)
{
    Pageable pageable = PageRequest.of(pageNo,pageSize,(Sort.by(Sort.Direction.ASC, "lastName","dateOfBirth")));
    Page<User> users;
    if(searchTerm == null || searchTerm.trim().isEmpty())
    {
        users = userRepo.findAll(pageable);
    }
    else
    {
        String trimmedSearch = searchTerm.trim();
        users = userRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressContainingIgnoreCaseOrPhoneNumberIgnoreCase(trimmedSearch, trimmedSearch, trimmedSearch,trimmedSearch,pageable);
    }
    return users.stream().map(this::convertToDto).toList();
}

    public UserDTO getById(Long id)
    {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        }
        User user = optionalUser.get();
        return convertToDto(user);
    }

    public UserDTO createUser(UserDTO userDTO) {

        Optional<User> userEmail = userRepo.findByEmailAddress(userDTO.getEmailAddress());
        Optional<User> userPhone = userRepo.findByPhoneNumber(userDTO.getPhoneNumber());
        if (userEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with Email: "+userDTO.getEmailAddress() + " already exists.");
        }
        if(userPhone.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with Phone Number : "+ userDTO.getPhoneNumber()+ " already exists.");
        }

        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDateOfBirth(),userDTO.getPhoneNumber(),userDTO.getEmailAddress());
        userRepo.save(user);
        return convertToDto(user);
    }

    public UserDTO updateUser(Long id ,UserDTO userDTO) {

        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        Optional<User> userPhone = userRepo.findByPhoneNumber(userDTO.getPhoneNumber());
        Optional<User> userEmail = userRepo.findByEmailAddress(userDTO.getEmailAddress());
        if (userEmail.isPresent() && userEmail.get().getId() != id) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with Email: "+userDTO.getEmailAddress() + " already exists.");
        }
        if (userPhone.isPresent() && userPhone.get().getId() != id) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with Phone Number : "+ userDTO.getPhoneNumber()+ " already exists.");
        }

        User existingUser = optionalUser.get();

        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmailAddress(userDTO.getEmailAddress());
        existingUser.setDateOfBirth(userDTO.getDateOfBirth());
        existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        userRepo.save(existingUser);
        return convertToDto(existingUser);
    }

    public ResponseEntity<ApiResponse> deleteUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepo.deleteById(id);
        HttpStatusCode httpStatus = HttpStatus.OK;
        String message = "Successfully deleted user with ID: " + id;
        ApiResponse apiResponse = new ApiResponse(httpStatus,message);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}


