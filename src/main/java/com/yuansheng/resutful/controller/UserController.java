package com.yuansheng.resutful.controller;

import com.yuansheng.resultful.domain.Blog;
import com.yuansheng.resultful.domain.BlogExtra;
import com.yuansheng.resultful.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.yuansheng.resultful.core.common.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private BlogService blogService;

	//列出所有博客数据
	@RequestMapping(value="/bolg_list",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> listBlog(){
		Map<String,Object> result=new HashMap<String,Object> ();
		result.put("blog",blogService.selectByAllandpic());
		return result;
	}

	// 删除某条博客
	@RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteBlog(@PathVariable("blogId") Integer blogId) {
		if(blogService.deleteUserById(blogId)>0){
			JsonResult jsonResult = JsonResult.getInstance(0, "删除成功");
			return jsonResult.toString();
		}
		JsonResult jsonResult = JsonResult.getInstance(0, "删除失败");
		return jsonResult.toString();
	}

	//上传图片文件
	@RequestMapping(value = "uploadimg")
	@ResponseBody
	//@RequestParam("fileData")为input 的name属性
	public Map<String,Object> uploadimg(@RequestParam("fileData")MultipartFile file, HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object> ();
		// 文件不为空
		if(!file.isEmpty()) {
			//上传路径
			String path = request.getSession().getServletContext().getRealPath("/upload");
			// 文件名称
			System.out.println("----------------------------------------"+path);
			String fileName = file.getOriginalFilename();
			File dir = new File(path, fileName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			//		MultipartFile自带的解析方法
			try {
				// 转存文件
				file.transferTo(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String file_Name = request.getContextPath() + "/upload/" + fileName;
			result.put("errno",0);
			result.put("data",file_Name);
			return result;
		}
		result.put("errno","上传出错");
		result.put("data","file_Name");
		return result;
	}


	// 修改某条用户的信息
	@RequestMapping(value = "/{blogId}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateBlog(@PathVariable("blogId")Integer blogId,Blog blog) {
		blog.setId(blogId);
		if(blogService.updateSelective(blog)>0){
			JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
			return jsonResult.toString();
		}
		JsonResult jsonResult = JsonResult.getInstance(0, "修改失败");
		return jsonResult.toString();
	}

	//根据id查询信息
	@RequestMapping(value = "/{blogId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")  //要produces = "application/json，不然返回错误
	@ResponseBody
	public Blog selectBlog(@PathVariable("blogId") Integer blogId) {
		System.out.println(blogId);
		return blogService.findBlogById(blogId);
	}

	// 添加
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addBlog(Blog blog) {
		blogService.addBlog(blog);
		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
		return jsonResult.toString();
	}

	// 添加有图片的博客
	@RequestMapping(value = "/addblogpic", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String addBlogpic(BlogExtra blogExtra) {
		blogService.addBlogpic(blogExtra);
		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
		return jsonResult.toString();
	}











	// 列出所有的用户
//	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//	public ModelAndView editUser() {
//		ModelAndView view = new ModelAndView("user/index");
//		view.addObject("users", entityService.listUser());
//		return view;
//	}

//	// 添加用户
//	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	public ModelAndView createUser() {
//		System.out.println("create 进来");
//		ModelAndView view = new ModelAndView("user/create");
//		return view;
//	}
//
//	// 添加用户
//	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String addUser(String name,Integer sex) {
//		entityService.addUser(name, sex);
//		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
//		return jsonResult.toString();
//	}

//	// 获取某个用户的信息
//	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
//	public ModelAndView editUser(@PathVariable("userId") Integer userId) {
//	    User user = entityService.findUserById(userId);
//		ModelAndView view = new ModelAndView("user/edit");
//		view.addObject("user", user);
//		return view;
//	}

//	// 修改某个用户的信息
//	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String updateUser(@PathVariable("userId") String userId,String name,Integer sex) {
//		System.out.println(userId+"  "+name+" "+sex);
//		JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
//		return jsonResult.toString();
//	}

//	// 删除某个某个用户
//	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String deleteUser(@PathVariable("userId") String userId) {
//		System.out.println(userId);
//		JsonResult jsonResult = JsonResult.getInstance(0, "删除用户");
//		return jsonResult.toString();
//	}

}
