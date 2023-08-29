package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.Status;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class Writer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Status status;
}
