package cn.net.yiyun.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/testRequestMappingController")
@Controller
public class TestRequestMapping {

	private final String SUCCESS = "success";

	/**
	 * ���� ModelAndView ������ͼ������
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {

		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		System.out.println("modelAndView");
		return modelAndView.addObject("date",new Date());

	}

	/**
	 * ����servletԭ��̬api
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {
		System.out.println("testServletAPI" + request + "     " + response);

		return SUCCESS;
	}

	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println(user);

		return SUCCESS;
	}

	@RequestMapping("/testRequestMapping")
	public String test() {

		System.out.println("TestRequestMapping");

		return SUCCESS;
	}

	/**
	 * ָ������ʽΪpost�ύ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {

		System.out.println("testMethod");
		return SUCCESS;
	}

	/**
	 * ����params ������Ҫ��url�б����params��ָ������
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testParams", params = { "userName", "passWord" })
	public String testParams() {

		System.out.println("testParams");

		return SUCCESS;

	}

	/**
	 * ���� @PathVariable ����·����������֧֮��rest���������ʽ��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVar/{id}")
	public String testPathVar(@PathVariable("id") Integer id) {

		System.out.println("testPathVar" + id);
		return SUCCESS;

	}

	@RequestMapping(value = "/testRestGet/{id}", method = RequestMethod.GET)
	public String testRestGet(@PathVariable("id") Integer id) {

		System.out.println("testRestGet" + id);
		return SUCCESS;

	}

	@RequestMapping(value = "/testRestPost", method = RequestMethod.POST)
	public String testRestPost() {

		System.out.println("testRestPost");
		return SUCCESS;

	}

	@RequestMapping(value = "/testRestDelete/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {

		System.out.println("testRestDelete" + id);
		return SUCCESS;

	}

	@RequestMapping(value = "/testRestPut/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {

		System.out.println("testRestPut" + id);
		return SUCCESS;

	}

	/**
	 * ���� @RequestParam ע�� ��������urlȡֵ required ��ʾ�ò����Ƿ��Ǳ����е� defaultValue �����εĻ� ����Ĭ��ֵ
	 */
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.GET)
	public String testRequestParam(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "username", required = false) String username) {

		System.out.println("testRequestParam  id=" + id + "username=" + username);
		return SUCCESS;

	}
}
