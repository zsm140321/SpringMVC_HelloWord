package cn.net.yiyun.handler;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.net.yiyun.model.User;

//@SessionAttributes ע��ֻ�ܷŵ�����
//@SessionAttributes(value = { "name", "user" })
@RequestMapping("/testRequestMappingController")
@Controller
public class TestRequestMapping {

	private final String SUCCESS = "success";

	// @ModelAttribute ע�� ִ���κη���ǰ��ִ�б��@ModelAttribute �ķ���
	/**
	 *   ��������:
	 * 1. ִ�� @ModelAttribute ע�����εķ���: �����ݿ���ȡ������, �Ѷ�����뵽�� Map ��. ��Ϊ: user
	 * 2. SpringMVC �� Map ��ȡ�� User ����, ���ѱ���������������� User ����Ķ�Ӧ����.
	 * 3. SpringMVC ������������Ŀ�귽���Ĳ���. 
	 * 
	 * ע��: �� @ModelAttribute ���εķ�����, ���뵽 Map ʱ�ļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ��!
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id,Map<String,Object> map) {

		if (id != null) {
			
			System.out.println(id);
			User user = new User("zhaohsunmin", "1124609437", "qswe140321dd.");
			
			System.out.println("@ModelAttribute");
		   /**
		    * ע�� @ModelAttribute ���εķ�����, ���뵽 Map ʱ�ļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ��!
		    */
			map.put("user", user);
			
			System.out.println(user);
		}

	}

	@RequestMapping("/updataUser")
	public String updataUser(User user) {

		System.out.println("�޸Ĳ���" + user);
		return SUCCESS;
	}

	/**
	 * ����SessionAttribute
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map) {

		User user = new User("zhaoshumin", "1124609437", "qswe140321dd.");
		map.put("name", Arrays.asList("����", "����", "����"));
		map.put("user", user);
		return SUCCESS;

	}

	/**
	 * 
	 * ����map
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("name", Arrays.asList("����", "����", "����"));

		return SUCCESS;

	}

	/**
	 * ���� ModelAndView ������ͼ
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {

		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		System.out.println("modelAndView");
		// modelAndView.addObject �ѽ���ŵ��������
		return modelAndView.addObject("date", new Date());

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
