package jpabook.jpashop.controller;

import java.util.List;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.dto.AnswerForm;
import jpabook.jpashop.domain.dto.QuestionForm;
import jpabook.jpashop.domain.entity.Question;
import jpabook.jpashop.repository.QuestionRepository;
import jpabook.jpashop.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/question")
@RequiredArgsConstructor // questionRepository 객체 주입.
// 롬복이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 줌
@Controller
public class QuestionController {

    //    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {    // 매개변수로 Model을 지정하면 객체가 자동으로 생성
//        List<Question> questionList = this.questionRepository.findAll();
        // 컨트롤러에서 엔티티 바로 연결
        List<Question> questionList = this.questionService.getList();
        // 서비스를 통해 연결
        model.addAttribute("questionList", questionList);
        {
            return "question_list";
        }
    }

    @GetMapping(value="/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

//    @PostMapping("/create")
//    public String questionCreate(@RequestParam(value="subject") String subject,
//                                 @RequestParam(value="content") String content){
//        //Todo  질문저장
//        this.questionService.create(subject, content);
//        return "redirect:/question/list";
//    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
