package c.caique.offlineformsync.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import c.caique.offlineformsync.R;
import c.caique.offlineformsync.model.Post;
import c.caique.offlineformsync.presenter.PostPresenter;

public class MainActivity extends AppCompatActivity implements PostView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostPresenter postPresenter = new PostPresenter(this);
        postPresenter.getPosts();
    }

    @Override
    public void postsReady(List<Post> posts) {
        for(Post p : posts){
            Log.i("POST: ",p.toString());
        }
    }
}
