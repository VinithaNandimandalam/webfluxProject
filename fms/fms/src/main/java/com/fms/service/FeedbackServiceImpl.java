package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.domain.Answers;
import com.fms.domain.Questions;
import com.fms.repository.AnswersRepository;
import com.fms.repository.QuestionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	QuestionRepository repo;
	@Autowired
	AnswersRepository answersRepository;

	@Override
	public Flux<Questions> getAllQuestions() {
	
		Flux<Questions> questions=repo.findAll();
		System.out.println(questions);
		return questions.log();
	}
	
	@Override
	public Flux<Questions> getAllQuestionsById(int id) {
		
		Flux<Questions> questions_feedbackType=repo.findQuestionsById(id);
		System.out.println(questions_feedbackType);
		return questions_feedbackType.log();
	}
	@Override
public Mono<Questions> saveQuestion(Questions question){
		
		System.out.println("------- anna------"+question.getQ_id());
		Mono<Questions> count=repo.save(question);
		System.out.println(count);
		return count.log();
	}
	
	@Override
public Mono<Answers> saveAnswer(Answers answer){
		
		/* System.out.println("------- anna------"+answer.getQ_id()); */
		Mono<Answers> count= answersRepository.save(answer);
		System.out.println(count);
		return count.log();
	}

	@Override
	public Mono<Void> deleteAnswerById(Long id) {
		
		return answersRepository.deleteById(id);
	}
	

}
