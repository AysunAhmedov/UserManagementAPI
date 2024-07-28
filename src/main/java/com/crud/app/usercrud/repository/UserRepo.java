package com.crud.app.usercrud.repository;

import com.crud.app.usercrud.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Page<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailAddressContainingIgnoreCaseOrPhoneNumberIgnoreCase(String firstName, String lastName, String email, String phoneNumber, Pageable pageable);
    Optional<User> findByEmailAddress(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);

}
