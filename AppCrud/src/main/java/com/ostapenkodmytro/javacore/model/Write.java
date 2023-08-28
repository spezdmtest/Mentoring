package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Write {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Status status;

    public Write(String firstName, String lastName, List<Post> posts, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.status = status;
    }

    public void addPost(Post post) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
    }

}
