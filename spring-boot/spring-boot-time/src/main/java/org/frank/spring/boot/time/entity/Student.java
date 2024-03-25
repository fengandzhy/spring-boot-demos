package org.frank.spring.boot.time.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.frank.spring.boot.time.util.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;

public class Student {

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime birthday;

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
