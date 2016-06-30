package com.agh.tai.services;

import com.agh.tai.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class UserService implements IUserService
{
    private static final String REST_SERVICE_URI = "https://api.imgur.com/3";
    private static final String CLIENT_ID = "Client-ID 6e099b0f1a86a15";

    private final String token;
    private final String userName;

    public UserService(String userName, String accessToken)
    {
        this.token = String.format("Bearer %s", accessToken);
        this.userName = userName;
    }

    @Override
    public ImageData getImageByID(String id)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Achieving image with id %s...\n", id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", CLIENT_ID);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Image> response = restTemplate.exchange(String.format("%s/image/%s", REST_SERVICE_URI, id), HttpMethod.GET, new HttpEntity<Object>(headers), Image.class);
            System.out.println(String.format("Your image is here: %s", response.getBody().getImageData().getLink()));
            return response.getBody().getImageData();
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during geting image with id %s", id));
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ImageData uploadImageByUrl(String filePath)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Adding image located %s...\n", filePath));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();
        parameters.add("image", filePath);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String,String>> entity =
                new HttpEntity<MultiValueMap<String, String>>(parameters, headers);

        try
        {
            ResponseEntity<Image> response = restTemplate.exchange(String.format("%s/image", REST_SERVICE_URI), HttpMethod.POST, entity, Image.class);
            System.out.println(String.format("Your image is here: %s", response.getBody().getImageData().getLink()));
            return response.getBody().getImageData();
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during uploading image under %s", filePath));
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String deleteImageById(String imageId)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Deleting image with id %s...\n", imageId));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Basic> response = restTemplate.exchange(String.format("%s/image/%s", REST_SERVICE_URI, imageId), HttpMethod.DELETE, new HttpEntity<Object>(headers), Basic.class);
            System.out.println(String.format("Is your image deleted? : %s", String.valueOf(response.getBody().getData())));
            return response.getBody().getData();
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during deletion of the image with id %s", imageId));
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getUserFavourites()
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Getting %s favorite images...\n", userName));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<ImagesList> response = restTemplate.exchange(String.format("%s/account/%s/favorites", REST_SERVICE_URI, userName), HttpMethod.GET, new HttpEntity<Object>(headers), ImagesList.class);
            System.out.println(String.format("Your favourite images collection has %d elemtents", response.getBody().getImages().size()));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during getting favorite images of %s", userName));
            e.printStackTrace();
        }
    }

    @Override
    public ImagesList getUserImages(int page)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Getting %s images...\n", userName));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();
        try
        {
            ResponseEntity<ImagesList> response = restTemplate.exchange(String.format("%s/account/%s/images/%d", REST_SERVICE_URI, userName, page), HttpMethod.GET, new HttpEntity<Object>(headers), ImagesList.class);
            System.out.println(String.format("Your images collection has %d elemtents", response.getBody().getImages().size()));
            return response.getBody();
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during getting images of %s", userName));
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void getImagesByTag(String tagName, int page)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Getting #%s images from page %d...\n", tagName, page));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Tag> response = restTemplate.exchange(String.format("%s/gallery/t/%s/viral/%d", REST_SERVICE_URI, tagName, page), HttpMethod.GET, new HttpEntity<Object>(headers), Tag.class);
            System.out.println(String.format("There are %d images under tag #%s", response.getBody().getTagData().getItems().size(), tagName));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during getting #%s images", tagName));
            e.printStackTrace();
        }
    }

    @Override
    public void voteForImage(String imageId, String vote)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Voting fot the image with id #%s...\n", imageId));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Basic> response = restTemplate.exchange(String.format("%s/gallery/image/%s/vote/%s", REST_SERVICE_URI, imageId, vote), HttpMethod.POST, new HttpEntity<Object>(headers), Basic.class);
            System.out.println(String.format("Is voting completed? : #%s", String.valueOf(response.getBody().getData())));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during voting for iamge with id #%s images", imageId));
            e.printStackTrace();
        }
    }

    @Override
    public String favouriteOrUnfavouriteImageById(String imageId)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Favouriting/Unfavouriting image with id #%s...\n", imageId));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Basic> response = restTemplate
                    .exchange(String.format("%s/image/%s/favorite", REST_SERVICE_URI, imageId), HttpMethod.POST, new HttpEntity<>(headers), Basic.class);
            System.out.println(String.format("Image with id #%s has been %s", imageId, String.valueOf(response.getBody().getData())));
            return response.getBody().getData();
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during favouriting/unfavouriting iamge with id #%s", imageId));
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void getPopularImagesByPage(int page)
    {
        System.out.println(String.format("----------------------------------------------------------------------------------------"));
        System.out.println(String.format("Getting popular images from page %d...\n", page));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<ImagesList> response = restTemplate
                    .exchange(String.format("%s/gallery/hot/viral/%d.json", REST_SERVICE_URI, page), HttpMethod.GET, new HttpEntity<>(headers), ImagesList.class);

            System.out.println(String.format("%d popular images from page %d has been loaded", response.getBody().getImages().size(), page));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occurred during getting popular images from page %d", page));
            e.printStackTrace();
        }
    }
}