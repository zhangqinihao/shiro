package cn.jiyun.mapper;

import cn.jiyun.pojo.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsrMapper {

     public Usr queryUsrByName(String name);


}
