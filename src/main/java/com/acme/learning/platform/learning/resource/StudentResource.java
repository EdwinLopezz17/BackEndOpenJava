package com.acme.learning.platform.learning.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource{
    private Long Id;
    private String name;
    private int age;
    private String address;
}
