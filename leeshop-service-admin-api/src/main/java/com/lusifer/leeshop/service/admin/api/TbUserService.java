package com.lusifer.leeshop.service.admin.api;

import com.github.pagehelper.PageInfo;
import com.lusifer.leeshop.domain.TbUser;

public interface TbUserService {
    public PageInfo<TbUser> page(int pageNum, int pageSize);
}
