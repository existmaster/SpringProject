package com.existmaster.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by existmaster on 2015. 8. 25..
 */
@Entity
public class NameType {

    @Id
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
