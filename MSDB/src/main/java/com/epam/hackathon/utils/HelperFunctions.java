package com.epam.hackathon.utils;

import com.epam.hackathon.api.pojos.VideoDetails;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HelperFunctions {

    public static  String getVideoTitleFromApi(String url){
        RequestSpecification request;
        request = given().baseUri("https://testathon-service.herokuapp.com/api/videos/title").contentType("application/json");
        ResponseBody response = request.get().getBody();
        VideoDetails videoDetailsFromApi = response.as(VideoDetails.class);
        return videoDetailsFromApi.getTitle();
    }


    public static int getRandomEvenNumbersFromFibonaciiSeries(int fibonaciiSize)
    {
        List<Integer> fibonaciiSeries = getEvenNumbersFromFibonacciSeries(fibonaciiSize);
        Random rand = new Random();
        return fibonaciiSeries.get(rand.nextInt(fibonaciiSeries.size()));
    }

    public static List<Integer> getEvenNumbersFromFibonacciSeries(int tillWhichValue) {
        List<Integer> list = new ArrayList<>();
        int n1=0,n2=1,n3;
        for(int i=2;i<=tillWhichValue;i++)
        {
            n3=n1+n2;
            if(n3%2==0 && n3>0 && n3<tillWhichValue) {
                list.add(n3);
            }
            n1=n2;
            n2=n3;
        }
        return list;
    }
}
