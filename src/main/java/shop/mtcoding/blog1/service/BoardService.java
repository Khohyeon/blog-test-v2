package shop.mtcoding.blog1.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog1.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog1.handler.ex.CustomApiException;
import shop.mtcoding.blog1.model.BoardRepository;
import shop.mtcoding.blog1.util.HtmlPaser;

@Transactional(readOnly = true)
@Service
public class BoardService {

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(BoardSaveReqDto boardSaveReqDto, int userId) {
        String thumbnail = HtmlPaser.getThumnail(boardSaveReqDto.getContent());

        int result = boardRepository.insert(boardSaveReqDto.getTitle(), boardSaveReqDto.getContent(),
                thumbnail, userId);
        if (result != 1) {
            throw new CustomApiException("글쓰기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
