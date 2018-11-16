package c.caique.offlineformsync.view;

import java.util.List;

import c.caique.offlineformsync.model.Post;

public interface PostView {

    void postsReady(List<Post> posts);
}
