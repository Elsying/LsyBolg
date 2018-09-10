package com.yuansheng.resutful.controller;

import com.yuansheng.resultful.domain.Ceshi;
import com.yuansheng.resultful.service.BlogService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yuansheng.resultful.core.common.JsonResult;
import com.yuansheng.resultful.domain.User;
import com.yuansheng.resultful.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService entityService;
	@Autowired
	private BlogService blogService;
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		//jackson默认写出的时间数据为时间戳， 这里修改为相应模式的时间数据输出格式
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	//测试接口
	@RequestMapping(value="/ceshi",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> ceshia(){
//		ModelAndView view = new ModelAndView();
		Map<String,Object> result=new HashMap<String,Object> ();
		result.put("blog",blogService.listBlog());
//		Date date = new Date();
//		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//		System.out.println(dateFormat.format(date));
//		result.put("ID",1);
//		result.put("title","titleaa");
//		result.put("summary","summaryaa");
//		result.put("releasedate",dateFormat.format(date));
//		result.put("clickhit",110);
//		result.put("replyhit",220);
//		result.put("content","aa");

		return result;
	}

	// 列出所有的用户
//	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//	public ModelAndView editUser() {
//		ModelAndView view = new ModelAndView("user/index");
//		view.addObject("users", entityService.listUser());
//		return view;
//	}

	// 添加用户
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public ModelAndView createUser() {
		System.out.println("create 进来");
		ModelAndView view = new ModelAndView("user/create");		
		return view;
	}

	// 添加用户
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String addUser(String name,Integer sex) {
		entityService.addUser(name, sex);
		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
		return jsonResult.toString();
	}

	// 获取某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public ModelAndView editUser(@PathVariable("userId") Integer userId) {
	    User user = entityService.findUserById(userId);
		ModelAndView view = new ModelAndView("user/edit");
		view.addObject("user", user);
		return view;
	}

	// 修改某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String updateUser(@PathVariable("userId") String userId,String name,Integer sex) {
		System.out.println(userId+"  "+name+" "+sex);
		JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
		return jsonResult.toString();
	}

	// 删除某个某个用户
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") String userId) {
		System.out.println(userId);
		JsonResult jsonResult = JsonResult.getInstance(0, "删除用户");
		return jsonResult.toString();
	}

}
