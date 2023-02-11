package shop.mtcoding.blog1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class BoardService {

    public void 글쓰기() {
    }

}
