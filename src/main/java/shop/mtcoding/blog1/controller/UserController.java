package shop.mtcoding.blog1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog1.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog1.dto.user.UserReq.LoginReqDto;
import shop.mtcoding.blog1.model.User;
import shop.mtcoding.blog1.model.UserRepository;
import shop.mtcoding.blog1.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {
        userService.회원가입(joinReqDto);
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {
        User principal = userService.로그인(loginReqDto);
        session.setAttribute("principal", principal);
        return "redirect:board/";
    }
}
