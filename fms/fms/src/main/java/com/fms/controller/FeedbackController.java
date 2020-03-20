package com.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.domain.Answers;
import com.fms.domain.Questions;
import com.fms.service.FeedbackServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;
	
	
	@GetMapping("/questions")
	public Flux<Questions> getAllQuestions(){
		return feedbackServiceImpl.getAllQuestions();
		
	}
	
	@GetMapping("/{id}")
	public Flux<Questions> getAllQuestionsById(@PathVariable int id){
		return feedbackServiceImpl.getAllQuestionsById(id);
		
	}
	
	
	@PostMapping("/add")
	public Mono<Questions> saveQuestion(@RequestBody Questions question){
		return feedbackServiceImpl.saveQuestion(question);
	}
	
	@PostMapping("/addAnswer")
	public Mono<Answers> saveAnswers(@RequestBody Answers answer){
		return feedbackServiceImpl.saveAnswer(answer);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteAnswer(@PathVariable Long id){
		return feedbackServiceImpl.deleteAnswerById(id);
	}

}
