package shop.mtcoding.blog1.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "user/hello";
    }
}
