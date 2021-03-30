package com.example.restfulservices.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1,"kenneth", new Date()));
        users.add(new User(2,"Alice", new Date()));
        users.add(new User(3,"Elena", new Date()));
    }

    /**
     *  전체 user 조회.
     * @return
     */
    public List<User> findAll(){
        return users;
    }

    /**
     *  특정 user 조회
     * @param id
     * @return
     */
    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     *  user 저장
     * @param user
     * @return
     */
    public User save (User user){
        if(user.getId() == 0){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
}
