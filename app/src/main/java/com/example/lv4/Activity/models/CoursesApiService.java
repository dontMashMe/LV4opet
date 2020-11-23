package com.example.lv4.Activity.models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoursesApiService {

    @GET("/vi/courses")
    Call<ApiCall> getCourses();
}
