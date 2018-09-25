package com.yuansheng.resultful.service.impl;

import com.yuansheng.resultful.domain.Blog;
import com.yuansheng.resultful.mapper.BlogMapper;
import com.yuansheng.resultful.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;


    @Override
    public List<Blog> listBlog() {
        return blogMapper.selectByAll();
    }

    @Override
    public void addBlog(Blog blog) {
        blogMapper.insertSelective(blog);
    }

    @Override
    public int deleteUserById(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void updateBlogById(Blog blog) {

    }

    @Override
    public Blog findBlogById(Integer blogId) {
        return blogMapper.selectByPrimaryKey(blogId);
    }

    @Override
    public int updateSelective(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }
}
