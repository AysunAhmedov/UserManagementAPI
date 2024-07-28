package com.crud.app.usercrud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

public class UserDTO {
    @Schema(hidden = true)
    private Long id;

    @NotBlank(message = "Please provide a First Name.")
    @Pattern(regexp="^[A-Za-z]*$",message = "First name should contain only letters.")
    @Size(min = 2,max = 50 , message = "First name should be between 2 and 50 letters.")
    @Schema(description = "The first name of the user.", example = "Aysun", minLength = 2, maxLength = 50)
    private String firstName;

    @NotBlank(message = "Please provide a Last Name.")
    @Pattern(regexp="^[A-Za-z]*$",message = "Last name should contain only letters.")
    @Size(min = 2,max = 50 , message = "Last name should be between 2 and 50 letters.")
    @Schema(description = "The last name of the user.", example = "Ahmedov", minLength = 2, maxLength = 50)
    private String lastName;

    @NotNull(message = "Please provide a date of birth.")
    @Past(message = "The date should be from the past.")
    @Schema(description = "The date of birth of the user.", example = "1994-05-30")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Please provide a phone number.")
    @Pattern(regexp="^\\d+$",message = "Phone number should contain only digits.")
    @Size(min = 10,max = 10, message = "Phone number must be exactly 10 digits.")
    @Schema(description = "The phone number of the user.", example = "0895916607", minLength = 10, maxLength = 10)
    private String phoneNumber;

    @NotBlank(message = "Please provide an E-mail.")
    @Schema(description = "The e-mail of the user", example = "aysun@gmail.com")
    @Email(message = "Please provide a valid email address.")
    private String emailAddress;


    public UserDTO() {
    }

    public UserDTO(Long id , String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
