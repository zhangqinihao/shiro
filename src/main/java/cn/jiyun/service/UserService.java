package cn.jiyun.service;

import cn.jiyun.mapper.UserMapper;
import cn.jiyun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;


  public User queryUsrByName(String name){

      return  userMapper.queryUsrByName(name);
  }



}
