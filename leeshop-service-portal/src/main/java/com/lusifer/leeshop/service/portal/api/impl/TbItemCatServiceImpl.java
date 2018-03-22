package com.lusifer.leeshop.service.portal.api.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.lusifer.leeshop.commons.utils.MapperUtils;
import com.lusifer.leeshop.domain.TbItemCat;
import com.lusifer.leeshop.service.portal.api.TbItemCatService;
import com.lusifer.leeshop.service.portal.mapper.TbItemCatMapper;
import com.lusifer.leeshop.service.redis.api.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class TbItemCatServiceImpl implements TbItemCatService {
    private static final Logger logger = LoggerFactory.getLogger(TbItemCatServiceImpl.class);

    private static final String REDIS_KEY_ITEM_CAT_PID = "itemCatPid%s";

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Reference(version = "1.0.0")
    private RedisService redisService;

    @Override
    public List<TbItemCat> selectByPid(long pid) {
        List<TbItemCat> list = Lists.newArrayList();

        String json = (String) redisService.get(String.format(REDIS_KEY_ITEM_CAT_PID, pid));

        // 没有缓存数据
        if (json == null) {
            Example example = new Example(TbItemCat.class);
            example.createCriteria().andEqualTo("parentId", pid);
            list = tbItemCatMapper.selectByExample(example);

            // 将数据放入缓存
            try {
                redisService.set(String.format(REDIS_KEY_ITEM_CAT_PID, pid), MapperUtils.obj2json(list));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        // 从缓存取数据
        else {
            try {
                list = MapperUtils.json2list(json, TbItemCat.class);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        return list;
    }
}
