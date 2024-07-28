package com.crud.app.usercrud.config;

public class Descriptions {

    public static final String GET_USERS = "Retrieve a paginated list of users.\n\n" +
            "Default paging values are: page number = 0, page size = 10.\n\n" +
            "Optionally, you can filter users by search term. Which can be either first name,last name,phone number or e-mail.\n\n " +
            "Result is sorted by last name and if there are users with the same last name then by date of birth.\n\n" +
            "If search term is not provided you will get all users sorted.";

    public static final String GET_USER_BY_ID = "Retrieve a single user by ID";

    public static final String CREATE_USER = "Creates a user.\n\n" +
            "To successfully create a new user you have to make sure to cover the following criteria.\n\n" +
            "First name must consist of only letters and be between 2 and 50 characters long.\n\n" +
            "Last name must consist of only letters and be between 2 and 50 characters long.\n\n" +
            "Date of birth should be in the past and in the following format: yyyy-mm-dd.\n\n" +
            "Phone number should contain exactly 10 digits and should be unique if there is existing user with the same phone number you will get an error.\n\n" +
            "Email should be a valid email example: aysun@gmail.com and should be unique if there is existing user with the same email you will get an error.";

    public static final String UPDATE_USER = "Update a user.\n\n" +
            "To successfully update a user you have to make sure to cover the following criteria.\n\n" +
            "First name must consist of only letters and be between 2 and 50 characters long.\n\n" +
            "Last name must consist of only letters and be between 2 and 50 characters long.\n\n" +
            "Date of birth should be in the past and in the following format: yyyy-mm-dd.\n\n" +
            "Phone number should contain exactly 10 digits and should be unique if there is existing user with the same phone number you will get an error.\n\n" +
            "Email should be a valid email example: aysun@gmail.com and should be unique if there is existing user with the same email you will get an error.";

    public static final String DELETE_USER = "Deletes a user by ID";
}
