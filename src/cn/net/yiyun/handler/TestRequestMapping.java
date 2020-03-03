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

//@SessionAttributes 注解只能放到类上
//@SessionAttributes(value = { "name", "user" })
@RequestMapping("/testRequestMappingController")
@Controller
public class TestRequestMapping {

	private final String SUCCESS = "success";

	// @ModelAttribute 注解 执行任何方法前先执行标记@ModelAttribute 的方法
	/**
	 *   运行流程:
	 * 1. 执行 @ModelAttribute 注解修饰的方法: 从数据库中取出对象, 把对象放入到了 Map 中. 键为: user
	 * 2. SpringMVC 从 Map 中取出 User 对象, 并把表单的请求参数赋给该 User 对象的对应属性.
	 * 3. SpringMVC 把上述对象传入目标方法的参数. 
	 * 
	 * 注意: 在 @ModelAttribute 修饰的方法中, 放入到 Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
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
		    * 注意 @ModelAttribute 修饰的方法中, 放入到 Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
		    */
			map.put("user", user);
			
			System.out.println(user);
		}

	}

	@RequestMapping("/updataUser")
	public String updataUser(User user) {

		System.out.println("修改操作" + user);
		return SUCCESS;
	}

	/**
	 * 测试SessionAttribute
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map) {

		User user = new User("zhaoshumin", "1124609437", "qswe140321dd.");
		map.put("name", Arrays.asList("张三", "李四", "王五"));
		map.put("user", user);
		return SUCCESS;

	}

	/**
	 * 
	 * 测试map
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("name", Arrays.asList("张三", "李四", "王五"));

		return SUCCESS;

	}

	/**
	 * 测试 ModelAndView 返回视图
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {

		ModelAndView modelAndView = new ModelAndView(SUCCESS);
		System.out.println("modelAndView");
		// modelAndView.addObject 把结果放到域对象里
		return modelAndView.addObject("date", new Date());

	}

	/**
	 * 测试servlet原生态api
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
	 * 指定请求方式为post提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {

		System.out.println("testMethod");
		return SUCCESS;
	}

	/**
	 * 测试params 参数。要求url中必须带params的指定参数
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testParams", params = { "userName", "passWord" })
	public String testParams() {

		System.out.println("testParams");

		return SUCCESS;

	}

	/**
	 * 测试 @PathVariable 访问路径带参数（之支持rest风格测参数形式）
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
	 * 测试 @RequestParam 注解 带参数的url取值 required 表示该参数是否是必须有的 defaultValue 不带参的话 设置默认值
	 */
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.GET)
	public String testRequestParam(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "username", required = false) String username) {

		System.out.println("testRequestParam  id=" + id + "username=" + username);
		return SUCCESS;

	}
}
