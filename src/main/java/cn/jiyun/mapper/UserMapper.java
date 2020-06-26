package cn.jiyun.mapper;

import cn.jiyun.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

     public User queryUsrByName(String name);


}
