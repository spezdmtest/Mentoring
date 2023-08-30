package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
public class Label {
    private Long id;
    private String name;
    private Status status;
}
