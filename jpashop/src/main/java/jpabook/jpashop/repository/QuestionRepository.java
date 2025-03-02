package jpabook.jpashop.repository;

import jpabook.jpashop.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
// Question 엔티티로 레포지터리를 생성한다는 의미
// Question 엔티티의 기본 키가 Integer임을 추가로 지정.
    Question findBySubject(String subject);
}
