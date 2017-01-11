package com.greenfox.exams.spring.repository;

import com.greenfox.exams.spring.domain.UserInput;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-11.
 */
public interface UserInputRepo extends CrudRepository<UserInput, Long> {
}
