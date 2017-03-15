package com.vertical.mm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//这个pageController是用来做页面跳转控制的
@Controller
public class PageController {
	@RequestMapping("/")//对根目录请求的拦截,跳转到首页
	public String showIndex(){
		return "index";
	}
	
	//该方法表示需要传递一个参数page,用来指定想要跳转到的页面
	@RequestMapping("/{page}")//page 是前端传过来的参数
	public String showPage(@PathVariable String page){
		return page;
	}
}
