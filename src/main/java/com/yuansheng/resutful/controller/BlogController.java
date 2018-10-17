package com.yuansheng.resutful.controller;

import com.yuansheng.resultful.service.BlogService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    //列出所有博客数据
    @RequestMapping(value="/bolg_list",method = RequestMethod.GET)
    @ResponseBody
    public String listBlog(){
//        Map<String,Object> result=new HashMap<String,Object>();
//        result.put("blog",blogService.listBlog());
        return "Hellowrold";
    }
}
