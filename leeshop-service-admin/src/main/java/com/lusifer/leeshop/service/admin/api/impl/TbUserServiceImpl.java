package com.lusifer.leeshop.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lusifer.leeshop.domain.TbUser;
import com.lusifer.leeshop.service.admin.api.TbUserService;
import com.lusifer.leeshop.service.admin.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service(version = "1.0.0")
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public PageInfo<TbUser> page(int pageNum, int pageSize) {
        Example example = new Example(TbUser.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbUser> tbUserPageInfo = new PageInfo<>(tbUserMapper.selectByExample(example));
        return tbUserPageInfo;
    }
}
