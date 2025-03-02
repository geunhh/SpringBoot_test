package jpabook.jpashop;

import jpabook.jpashop.domain.entity.Question;
import jpabook.jpashop.repository.QuestionRepository;
import jpabook.jpashop.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class JpashopApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void clearDatabase() {
		questionRepository.deleteAll();
	}

	@Test
	@Transactional
	void testJPA() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요???");
		q1.setContent("sb에 대해ㅓㅅ 알고싶소");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("sbb가 무엇..");
		q2.setContent("알고싶소");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);



		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

//		Question q = all.get(1);
//		assertEquals("sbb가 무엇..",q.getSubject());

		Question q = questionRepository.findBySubject("sbb가 무엇인가요???");
		assertNotNull(q, "데이터가 존재해야 합니다.");  // ✅ Null 체크 추가
		assertEquals("sbb가 무엇인가요???", q.getSubject());  // ✅ 올바른 값 비교



	}
}