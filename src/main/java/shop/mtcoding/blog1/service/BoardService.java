package shop.mtcoding.blog1.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog1.dto.board.BoardReq.BoardSaveReqDto;
import shop.mtcoding.blog1.model.BoardRepository;

@Transactional(readOnly = true)
@Service
public class BoardService {

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    public void 글쓰기(BoardSaveReqDto boardSaveReqDto) {
        boardRepository.insert(null, null, null, 0);
    }

}
