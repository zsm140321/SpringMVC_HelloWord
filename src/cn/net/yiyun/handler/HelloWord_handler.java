package cn.net.yiyun.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWord_handler {

	@RequestMapping("/spring_mvc")
	public String helloWord() {
		
		System.out.println("helloWord");

		return "success";

	}

}
