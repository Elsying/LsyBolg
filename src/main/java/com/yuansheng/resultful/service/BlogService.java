package com.yuansheng.resultful.service;

import com.yuansheng.resultful.domain.Blog;


import java.util.List;

public interface BlogService {
    public List<Blog> listBlog();

    public void addBlog(Blog blog);

    public void deleteUserById(Integer id);

    public void updateBlogById(Blog blog);

    public Blog findBlogById(Integer blogId);
}
