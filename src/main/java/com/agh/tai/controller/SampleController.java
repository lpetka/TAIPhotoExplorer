package com.agh.tai.controller;

import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;
import com.agh.tai.model.StringResponse;
import com.agh.tai.model.UserCredentials;
import com.agh.tai.services.IUserService;
import com.agh.tai.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SampleController {

    private final String startingWebsite = "https://api.imgur.com/oauth2/authorize?client_id=6e099b0f1a86a15&response_type=token";

    IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView method()
    {
        return new ModelAndView("redirect:" + startingWebsite);
    }

    @RequestMapping(value = "/user/credentials", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody UserCredentials addUserCredentials(@RequestBody UserCredentials userCredentials,
                                                            HttpSession session) {
        session.setAttribute("access_token", userCredentials.getAccessToken());
        session.setAttribute("refresh_token", userCredentials.getRefreshToken());
        session.setAttribute("account_username", userCredentials.getAccountUsername());
        return userCredentials;
    }

    @RequestMapping(value="/user/gallery", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ImagesList getUserImages(@RequestHeader(value = "access_token") String accessToken,
                                                  @RequestHeader(value = "account_username") String accountUsername,
                                                  @RequestBody String pageNumber) {
        userService = new UserService(accountUsername, accessToken);
        return userService.getUserImages(Integer.valueOf(pageNumber));
    }

    @RequestMapping(value="/image/details", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ImageData getImageById(@RequestHeader(value = "access_token") String accessToken,
                                                  @RequestHeader(value = "account_username") String accountUsername,
                                                  @RequestBody String imageId) {
        userService = new UserService(accountUsername, accessToken);
        return userService.getImageByID(imageId);
    }

    @RequestMapping(value = "/image/remove", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody StringResponse removeImageById(@RequestHeader(value = "access_token") String accessToken,
                                   @RequestHeader(value = "account_username") String accountUsername,
                                   @RequestBody String imageId) {
        userService = new UserService(accountUsername, accessToken);
        if(userService.deleteImageById(imageId) != null)
            return new StringResponse(imageId);
        else
            return null;
    }

    @RequestMapping(value="/image/upload", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ImageData uploadImageFromUrl(@RequestHeader(value = "access_token") String accessToken,
                                                @RequestHeader(value = "account_username") String accountUsername,
                                                @RequestBody String imageUrl) {
        userService = new UserService(accountUsername, accessToken);
        return userService.uploadImageByUrl(imageUrl);
    }

    @RequestMapping(value="/image/togglefavourite", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody StringResponse toggleFavourite(@RequestHeader(value = "access_token") String accessToken,
                                                      @RequestHeader(value = "account_username") String accountUsername,
                                                      @RequestBody String imageId) {
        userService = new UserService(accountUsername, accessToken);
        return new StringResponse(userService.favouriteOrUnfavouriteImageById(imageId));
    }

    @RequestMapping(value="/user/favourites", method = RequestMethod.GET)
    public @ResponseBody ImagesList getUserFavourites(@RequestHeader(value = "access_token") String accessToken,
                                                      @RequestHeader(value = "account_username") String accountUsername) {
        userService = new UserService(accountUsername, accessToken);
        return userService.getUserFavourites();
    }

    @RequestMapping("/index")
    String index(Model model, HttpSession session) {
        model.addAttribute("message", "Logged in as " + session.getAttribute("account_username"));
        return "index";
    }

    @RequestMapping("/gallery")
    String gallery(Model model) {
        return "gallery";
    }

    @RequestMapping("/favourites")
    String favourites(Model model) {
        return "favourites";
    }
}
