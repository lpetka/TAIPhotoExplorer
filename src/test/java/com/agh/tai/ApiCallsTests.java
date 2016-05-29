package com.agh.tai;

import com.agh.tai.model.ImageData;
import com.agh.tai.services.UserService;

import java.util.Scanner;

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

        ImageData imageData = userService.uploadImageByUrl("http://www.gojackal.com/wp-content/uploads/2015/09/Photoshop-Fail-17.jpg");
        userService.getUserImages(0);
        userService.getUserFavourites();
        userService.deleteImageById(imageData.getId());
        userService.getUserImages(0);
        userService.getImagesByTag("cat", 2);
        userService.getImageByID("vYRQxQa");
        userService.voteForImage("vYRQxQa", "up");
        userService.voteForImage("vYRQxQa", "down");
    }
}