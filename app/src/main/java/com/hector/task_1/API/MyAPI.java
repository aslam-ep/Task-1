package com.hector.task_1.API;



import com.hector.task_1.DataModels.DataModel;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;


public interface MyAPI {
    @GET("issues")
    Observable<List<DataModel>> getDataModels();
}
