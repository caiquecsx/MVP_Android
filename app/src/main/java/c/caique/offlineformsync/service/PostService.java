package c.caique.offlineformsync.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    private Retrofit retrofit = null;

    public PostAPI postAPI(){
        String BASE_URL = "https://jsonplaceholder.typicode.com/";

        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PostAPI.class);
    }
}
