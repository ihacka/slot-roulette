package com.intralot.slotroulette.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.net.BindException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slotroulette/main")
public class MainController
{
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody String getInfo(BindException errors, Model model)
    {
        return "";
    }
}
