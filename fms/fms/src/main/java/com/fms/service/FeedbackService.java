package com.fms.service;

import com.fms.domain.Answers;
import com.fms.domain.Questions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackService {
	Flux<Questions> getAllQuestions();
	Flux<Questions> getAllQuestionsById(int id);
    Mono<Questions> saveQuestion(Questions question);
    Mono<Answers> saveAnswer(Answers answer);
    Mono<Void> deleteAnswerById(Long id);
	
}
