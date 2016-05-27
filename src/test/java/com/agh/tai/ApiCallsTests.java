package com.agh.tai;

import com.agh.tai.services.UserService;

public class ApiCallsTests {

    public static void main(String args[])
    {
        UserService userService = new UserService();

        userService.getImageByID(5324);
    }
}
