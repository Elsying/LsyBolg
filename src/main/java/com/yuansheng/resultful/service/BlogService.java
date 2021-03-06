package com.yuansheng.resultful.service;

import com.yuansheng.resultful.domain.Blog;
import com.yuansheng.resultful.domain.BlogExtra;


import java.util.List;

public interface BlogService {
    public List<Blog> listBlog();

    public void addBlog(Blog blog);
    public void addBlogpic(BlogExtra blogExtra);

    public int deleteUserById(Integer id);

    public void updateBlogById(Blog blog);

    public Blog findBlogById(Integer blogId);

    public int updateSelective(Blog blog);

    List<BlogExtra> selectByAllandpic();


}
