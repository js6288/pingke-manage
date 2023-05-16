package manage.service;

import manage.mapper.UserMapper;
import manage.pojo.User;
import manage.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers() {
       return userMapper.selectByExample(null);
    }
}
