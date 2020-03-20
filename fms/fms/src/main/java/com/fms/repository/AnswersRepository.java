package com.fms.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fms.domain.Answers;

public interface AnswersRepository extends ReactiveCrudRepository<Answers, Long> {

}
