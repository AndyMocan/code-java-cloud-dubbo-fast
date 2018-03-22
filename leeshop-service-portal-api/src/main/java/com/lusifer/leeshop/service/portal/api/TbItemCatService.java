package com.lusifer.leeshop.service.portal.api;

import com.lusifer.leeshop.domain.TbItemCat;

import java.util.List;

public interface TbItemCatService {
    public List<TbItemCat> selectByPid(long pid);
}
