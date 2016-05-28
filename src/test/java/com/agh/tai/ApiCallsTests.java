package com.agh.tai;

import com.agh.tai.services.UserService;

import java.util.Scanner;
import java.util.StringJoiner;

public class ApiCallsTests {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program created to test api calls used in the project. Please enter credentials (userName and accessToken)\t");

        System.out.println("UserName:\t");
        String userName = scanner.nextLine();

        System.out.println("AccessToken:\t");
        String accessToken = scanner.nextLine();

        UserService userService = new UserService(userName, accessToken);

        userService.getImageByID(5324);
        userService.uploadImageAnonymouslyByUrl("http://www.gojackal.com/wp-content/uploads/2015/09/Photoshop-Fail-17.jpg");
        userService.getUserFavourites();
        userService.getUserImages(0);
    }
}
