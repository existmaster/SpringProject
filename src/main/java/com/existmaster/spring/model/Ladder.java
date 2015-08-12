package com.existmaster.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by existmaster on 2015. 8. 11..
 */

public class Ladder {

    private int id;


    private List<Boolean> active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Boolean> getActive() {
        return active;
    }

    public void setActive(List<Boolean> active) {
        this.active = active;
    }
}
