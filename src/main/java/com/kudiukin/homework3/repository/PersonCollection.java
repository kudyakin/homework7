package com.kudiukin.homework3.repository;

import com.kudiukin.homework3.model.Person;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class PersonCollection {

    private final Map<Integer, Person> persons = new HashMap<>();

}
