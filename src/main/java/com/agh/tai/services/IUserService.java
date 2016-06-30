package com.agh.tai.services;

import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;

public interface IUserService
{
    ImageData getImageByID(String id);

    ImageData uploadImageByUrl(String filePath);

    String deleteImageById(String imageId);

    void getUserFavourites();

    ImagesList getUserImages(int page);

    void getImagesByTag(String tagName, int page);

    void voteForImage(String imageId, String vote);

    String favouriteOrUnfavouriteImageById(String imageId);
    void favouriteOrUnfavouriteImageById(String imageId);

    void getPopularImagesByPage(int page);
}
