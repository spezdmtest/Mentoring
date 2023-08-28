package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.PostStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private Long id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;
    private PostStatus postStatus;

    public Post(String content, Date created, Date updated, List<Label> labels, PostStatus postStatus) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.postStatus = postStatus;
    }
}
