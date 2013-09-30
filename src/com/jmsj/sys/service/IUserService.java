
package com.jmsj.sys.service;

import java.util.List;

import com.jmsj.sys.entity.User;


public interface IUserService {


    public boolean add(User user);

    public boolean delete(String id);
    
    public User isHave(String userName);

    public List<User> list(int pageNo,int pageNum);

    public User login(String userName,String passwd);
    
    public User getUser(String userId);
    
    public boolean update(User user);

}
