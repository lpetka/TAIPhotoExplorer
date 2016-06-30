package com.agh.tai.services;

import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;
import com.agh.tai.model.TagData;

public interface IUserService
{
    ImageData getImageByID(String id);

    ImageData getImageFromGalleryByID(String id);

    ImageData uploadImageByUrl(String filePath);

    String deleteImageById(String imageId);

    ImagesList getUserFavourites();

    ImagesList getUserImages(int page);

    TagData getImagesByTag(String tagName, int page);

    void voteForImage(String imageId, String vote);

    ImagesList getPopularImagesByPage(int page);

    String favouriteOrUnfavouriteImageById(String imageId);

}
