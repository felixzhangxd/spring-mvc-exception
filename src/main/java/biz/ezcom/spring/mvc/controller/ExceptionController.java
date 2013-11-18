package biz.ezcom.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/exception" })
public class ExceptionController {
    @RequestMapping(value = { "/input" })
    public void input() throws Exception {
        throw new Exception("Exception");
    }

    /**
     * 1.局部异常 最小匹配原则
     * 2.全局异常 匹配
     */
    @ExceptionHandler(value = { Throwable.class })
    public String handlerException(Throwable e) {
        System.out.println(e.getMessage());
        return "/exception/exception";
    }
}
