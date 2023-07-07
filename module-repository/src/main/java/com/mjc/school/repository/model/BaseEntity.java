package com.mjc.school.repository.model;

import javax.persistence.Entity;

public interface BaseEntity<K> {

    K getId();

    void setId(K id);
}
