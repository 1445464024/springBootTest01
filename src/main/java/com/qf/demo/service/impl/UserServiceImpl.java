package com.qf.demo.service.impl;

import com.qf.demo.entity.TUser;
import com.qf.demo.mapper.TUserMapper;
import com.qf.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YinZhi
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
