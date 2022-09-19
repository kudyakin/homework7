package com.kudiukin.homework4.repository;

import com.kudiukin.homework4.model.Person;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class PersonCollection {

    private final Map<Integer, Person> persons = new HashMap<>();

}
