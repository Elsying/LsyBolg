package com.yuansheng.resultful.domain;

import java.util.List;


public class BlogExtra extends Blog{
    private List<Pic> pic;//图片

    public List<Pic> getPic() {
        return pic;
    }

    public void setPic(List<Pic> pic) {
        this.pic = pic;
    }
}
