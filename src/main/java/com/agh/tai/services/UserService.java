package com.agh.tai.services;

import com.agh.tai.model.ImagesList;
import com.agh.tai.model.Image;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class UserService {

    private static final String REST_SERVICE_URI = "https://api.imgur.com/3";
    private static final String CLIENT_ID = "Client-ID 6e099b0f1a86a15";

    private final String token;
    private final String userName;

    public UserService(String userName, String accessToken)
    {
        this.token = String.format("Bearer %s", accessToken);
        this.userName = userName;
    }

    public void getImageByID(int id)
    {
        System.out.println(String.format("\nAchieving image with id %d............", id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", CLIENT_ID);

        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Image> response = restTemplate.exchange(String.format("%s/image/%d", REST_SERVICE_URI, id), HttpMethod.GET, new HttpEntity<Object>(headers), Image.class);
            System.out.println(String.format("\nYour image is here: %s", response.getBody().getImageData().getLink()));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occured during geting image with id %d", id));
            e.printStackTrace();
        }
    }

    public void uploadImageAnonymouslyByUrl(String filePath)
    {
        System.out.println(String.format("\nAdding image located %s............", filePath));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", CLIENT_ID);

        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();
        parameters.add("image", filePath);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String,String>> entity =
                new HttpEntity<MultiValueMap<String, String>>(parameters, headers);

        try
        {
            ResponseEntity<Image> response = restTemplate.exchange(String.format("%s/image", REST_SERVICE_URI), HttpMethod.POST, entity, Image.class);
            System.out.println(String.format("\nYour image is here: %s", response.getBody().getImageData().getLink()));
        }
        catch (HttpClientErrorException e)
        {
            System.out.println(String.format("Error occured during uploading image under %s", filePath));
            e.printStackTrace();
        }
    }
}