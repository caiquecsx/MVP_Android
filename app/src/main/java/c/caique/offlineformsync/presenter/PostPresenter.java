package c.caique.offlineformsync.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import c.caique.offlineformsync.model.Post;
import c.caique.offlineformsync.service.PostService;
import c.caique.offlineformsync.view.PostView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter {

    private PostView postView;
    private PostService postService;

    public PostPresenter( PostView postView ){
        this.postView = postView;

        if(this.postService == null){
            this.postService = new PostService();
        }
    }

    public void getPosts(){
        postService
                .postAPI()
                .getPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        List<Post> posts = response.body();

                        if(posts != null){
                            postView.postsReady(posts);
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        try {
                            throw new InterruptedException("Somethin Wrong!");
                        }catch (InterruptedException ie){
                            ie.printStackTrace();
                        }
                    }
                });
    }
}
