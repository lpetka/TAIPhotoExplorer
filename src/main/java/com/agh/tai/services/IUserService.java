package com.agh.tai.services;

import com.agh.tai.model.GalleryItem;
import com.agh.tai.model.ImageData;
import com.agh.tai.model.ImagesList;

import java.util.List;

public interface IUserService
{
    ImageData getImageByID(String id);

    ImageData uploadImageByUrl(String filePath);

    String deleteImageById(String imageId);

    ImagesList getUserFavourites();

    ImagesList getUserImages(int page);

    List<GalleryItem> getImagesByTag(String tagName, int page);

    String voteForImage(String imageId, String vote);

    String favouriteOrUnfavouriteImageById(String imageId);

    ImagesList getPopularImagesByPage(int page);
}