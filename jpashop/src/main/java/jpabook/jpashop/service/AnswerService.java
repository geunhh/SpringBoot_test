package jpabook.jpashop.service;

import jpabook.jpashop.domain.entity.Answer;
import jpabook.jpashop.domain.entity.Question;
import jpabook.jpashop.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
// final 키워드가 붙은 필드를 매개변수로 받는 생성자를 자동 생성해줌.
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    // Answer 테이블과 연결된 JPA Repository.

    public void create(Question question, String content) {
        Answer answer = new Answer();   // 새로운 Answer 객체 생성
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
