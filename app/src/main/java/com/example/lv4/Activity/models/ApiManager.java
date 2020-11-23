package com.example.lv4.Activity.models;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static ApiManager instance;
    private CoursesApiService service;

    private ApiManager(){
        Retrofit.Builder builder = new Retrofit.Builder();

        Retrofit retrofit = builder.baseUrl("https://catalog-api.udacity.com/v1/courses")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CoursesApiService.class);
    }

    public static ApiManager getInstance(){
        if(instance == null){
            instance = new ApiManager();
        }return instance;
    }
    public CoursesApiService service(){
        return service();
    }
}
