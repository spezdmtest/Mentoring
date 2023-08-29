package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.PostStatus;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
public class Post {
    private Long id;
    private String content;
    private String created;
    private String updated;
    private List<Label> labels;
    private PostStatus postStatus;
}
