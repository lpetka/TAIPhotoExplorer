package com.agh.tai.services;

import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;

public interface IUserService
{
    ImageData getImageByID(String id);

    ImageData uploadImageByUrl(String filePath);

    String deleteImageById(String imageId);

    ImagesList getUserFavourites();

    ImagesList getUserImages(int page);

    void getImagesByTag(String tagName, int page);

    void voteForImage(String imageId, String vote);

    ImagesList getPopularImagesByPage(int page);

    String favouriteOrUnfavouriteImageById(String imageId);

}
