package com.agh.tai.services;

import com.agh.tai.model.ImageData;

public interface IUserService
{
    void getImageByID(String id);

    ImageData uploadImageByUrl(String filePath);

    void deleteImageById(String imageId);

    void getUserFavourites();

    void getUserImages(int page);

    void getImagesByTag(String tagName, int page);

    void voteForImage(String imageId, String vote);

    void favouriteOrUnfavouriteImageById(String imageId);
}
