package com.yanyd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "hello,spring mvc");
        return mv;
    }

}
