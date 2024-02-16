package com.riya.SpringBootWeb1;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @ModelAttribute("course")
    public String addCourse(){
        return "java";
    }


    @RequestMapping("/")
    public String home() {
        System.out.println("Home method called");
        return "index";
    }

    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));

        int result = num1 + num2;
//        session.setAttribute("result", result);
//        model.addAttribute("result", result);
        mv.addObject("result", result);
        mv.setViewName("result");
        return mv;

    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien){
//
//        Alien alien = new Alien();
//
//        alien.setId(aid);
//        alien.setName(aname);
//        mv.addObject("alien", alien);
//        mv.setViewName("result");
//        return mv;
        return "result";

    }


}