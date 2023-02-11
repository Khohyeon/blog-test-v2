package shop.mtcoding.blog1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog1.model.BoardRepository;
import shop.mtcoding.blog1.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String main() {
        return "board/main";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @PostMapping("/save")
    public String save() {
        boardService.글쓰기();
        return "";
    }

}
