package ru.aiber.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@AllArgsConstructor
@ToString
@Getter
public class Student {
    private long id;
    private String name;
    private Group group;

}
