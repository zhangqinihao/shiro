package cn.jiyun.service;

import cn.jiyun.mapper.UsrMapper;
import cn.jiyun.pojo.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsrService {
    @Autowired
    private UsrMapper usrMapper;


  public Usr queryUsrByName(String name){

      return  usrMapper.queryUsrByName(name);
  }



}
