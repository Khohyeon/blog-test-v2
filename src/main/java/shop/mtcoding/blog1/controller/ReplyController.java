package shop.mtcoding.blog1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog1.dto.reply.ReplyReq.ReplySaveReqDto;

@Controller
public class ReplyController {

    @PostMapping("/reply")
    public String save(ReplySaveReqDto replySaveReqDto) {

        return "";
    }
}
