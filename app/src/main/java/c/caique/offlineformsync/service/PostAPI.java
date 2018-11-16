package c.caique.offlineformsync.service;

import java.util.List;

import c.caique.offlineformsync.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

}
