package com.ldx.web.controller.dingdan;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xiadan")
public class XiadanController {
    @RequestMapping("/add")
    public String add() {

        return "dingdan/add";
    }
}
