package com.greenfox.exams.spring.repository;

import com.greenfox.exams.spring.domain.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-11.
 */
public interface ProjectRepo extends CrudRepository<Project, Long> {
}
