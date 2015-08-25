package com.existmaster.spring.repository;

import com.existmaster.spring.model.NameType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by existmaster on 2015. 8. 25..
 */
public interface NameTypeRepository extends JpaRepository<NameType, String> {
}
