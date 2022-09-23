package kopo.poly.controller;

import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SessionController {

    @GetMapping("/session/test")
    public String sessionTest(HttpSession session) {

        log.info(this.getClass().getName() + ".sessionTest Start!");

        // 세션 ID확인(다른 서버에서도 동일한 ID가 출력되는지 확인용
        String sessionId = session.getId();

        // 세션 저장하기
        session.setAttribute("test", "1234");

        // 세션 가져오기
        String test = CmmUtil.nvl((String) session.getAttribute("test"));

        // 가져온 세션 출력하기
        log.info("test : " + test);

        log.info(this.getClass().getName() + ".sessionTest End!");

        return sessionId;

    }
}

