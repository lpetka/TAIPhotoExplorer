package com.agh.tai;

import com.agh.tai.model.GalleryItem;
import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;
import com.agh.tai.services.IUserService;
import com.agh.tai.services.UserService;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class ApiCallsTests
{
    private IUserService userService;
    String testedImageLink = "http://i.telegraph.co.uk/multimedia/archive/03543/Narutos_selfie_344_3543114b.jpg";
    String testedImageId = "vYRQxQa";

    @Before
    public void setUp()
    {
        this.userService = new UserService("mzieluFAKE", "16a802a20a2c608c09b918e2eba8312016ddc7cd");
    }

    @Test
    public void getImageByIdTest()
    {
        ImageData imageData = userService.getImageByID(testedImageId);

        assertEquals(imageData.getId(), testedImageId);
    }

    @Test
    public void uploadImageByUrlTest()
    {
        ImageData imageData = userService.uploadImageByUrl(testedImageLink);

        assertEquals(imageData.getType(), "image/jpeg");
    }

    @Test
    public void deleteImageTest()
    {
        ImageData imageData = userService.uploadImageByUrl(testedImageLink);
        String response = userService.deleteImageById(imageData.getId());

        assertEquals(response, "true");
    }

    @Test
    public void getFavouritesTest()
    {
        ImageData imageData = userService.uploadImageByUrl(testedImageLink);
        ImagesList imagesStart = userService.getUserFavourites();
        userService.favouriteOrUnfavouriteImageById(imageData.getId());
        ImagesList imagesEnd = userService.getUserFavourites();

        assertEquals(imagesStart.getImages().size() + 1, imagesEnd.getImages().size());
    }

    @Test
    public void getTagImagesTest()
    {
        List<GalleryItem> images = userService.getImagesByTag("cat", 0).getItems();

        assertNotEquals(images.get(0), null);
    }

    @Test
    public void voteUpTest()
    {
        userService.voteForImage(testedImageId, "down");

        ImageData imageDataStart = userService.getImageByID(testedImageId);
        int upVotesStart = imageDataStart.getUps();

        userService.voteForImage(imageDataStart.getId(), "up");

        ImageData imageDataEnd = userService.getImageByID(testedImageId);
        int upVotesEnd = imageDataEnd.getUps();

        assertEquals(upVotesStart + 1, upVotesEnd);
    }

    @Test
    public void voteDownTest()
    {
        userService.voteForImage(testedImageId, "up");

        ImageData imageDataStart = userService.getImageByID(testedImageId);
        int upVotesStart = imageDataStart.getUps();

        userService.voteForImage(imageDataStart.getId(), "down");

        ImageData imageDataEnd = userService.getImageByID(testedImageId);
        int upVotesEnd = imageDataEnd.getUps();

        assertEquals(upVotesStart, upVotesEnd + 1);
    }

    @Test
    public void favouriteItemTest()
    {
        boolean isFavorite = userService.getImageByID(testedImageId).isFavorite();

        String result = userService.favouriteOrUnfavouriteImageById(testedImageId);

        if (isFavorite)
        {
            assertEquals(result, "unfavorited");

            result = userService.favouriteOrUnfavouriteImageById(testedImageId);

            assertEquals(result, "favorited");
        }
        else
        {
            assertEquals(result, "favorited");

            result = userService.favouriteOrUnfavouriteImageById(testedImageId);

            assertEquals(result, "unfavorited");
        }
    }

    @Test
    public void getPopularImagesTest()
    {
        ImagesList images = userService.getPopularImagesByPage(0);

        assertNotEquals(images.getImages().get(0), null);
    }
}