package com.agh.tai;

import com.agh.tai.services.IUserService;
import com.agh.tai.services.UserService;
import org.junit.*;
import static org.junit.Assert.*;

public class ApiCallsTests
{
    private IUserService userService;

    @Before
    public void setUp()
    {
        this.userService = new UserService("mzieluFAKE", "dsad");
    }

    @Test
    public void getImageByUrlTests()
    {
        String testedId = "vYRQxQa";

        userService.getImageByID("vYRQxQa");

    }
}