package com.ostapenkodmytro.javacore.model;

import com.ostapenkodmytro.javacore.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Label {
    private Long id;
    private String name;
    private Status status;

    public Label(String name, Status status) {
        this.name = name;
        this.status = status;
    }
}
