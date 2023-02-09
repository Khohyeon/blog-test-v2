package shop.mtcoding.blog1.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog1.dto.user.UserReq.JoinReqDto;
import shop.mtcoding.blog1.model.UserRepository;
import shop.mtcoding.blog1.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("join")
    public String join(JoinReqDto joinReqDto) {
        userService.회원가입(joinReqDto);
        return "";
    }
}
