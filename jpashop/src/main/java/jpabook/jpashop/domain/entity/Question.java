package jpabook.jpashop.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // 이렇게 어노테이션을 적용해야 스프링부트가 해당 클래스르 엔티티로 인식
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가하는 값
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    // question.getAnswerList() .
}
// 엔티티는 생성자에 의해서만 엔티티의 값을 저장할 수 있게 하고,
// 데이터를 변경해야하는 경우 메서드를 추가로 작성하자.
// Setter 메서드 사용은 지양. - DB와 바로 연결되기 때문.