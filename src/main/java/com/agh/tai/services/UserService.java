package com.agh.tai.services;

import com.agh.tai.model.Image;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class UserService {

    public static final String REST_SERVICE_URI = "https://api.imgur.com/3";
    public static final String CLIENT_ID = "Client-ID 6e099b0f1a86a15";

    public void getImageByID(int id)
    {
        System.out.println(String.format("Achieving image with id %d............", id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", CLIENT_ID);
        RestTemplate restTemplate = new RestTemplate();

        try
        {
            ResponseEntity<Image> response = restTemplate.exchange(String.format("%s/image/%d", REST_SERVICE_URI, id), HttpMethod.GET, new HttpEntity<Object>(headers), Image.class);
            System.out.println(String.format("Your image is here: %s", response.getBody().getImageData().getLink()));
        }
        catch (HttpClientErrorException e)
        {
            e.printStackTrace();
            System.out.println(String.format("Error occured during geting image with id %d", id));
        }
    }
}