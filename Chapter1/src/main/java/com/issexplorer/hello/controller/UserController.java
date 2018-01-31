package com.issexplorer.hello.controller;

import com.issexplorer.hello.model.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// 配置 Class 级别的 RequestMapping，会整个 Class 的映射都在这下面，如果 "/users"

@RestController
@RequestMapping(value = "/users")
public class UserController {

    //
    private static Map<Long, UserEntity> users = Collections.synchronizedMap(new HashMap<Long, UserEntity>());

    /**
     * 处理"/users/"的 GET 请求
     * <p>
     * "http://localhost:8080/users/"
     *
     * @return List<UserEntity>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserEntity> getUserList() {
        return new ArrayList<>(users.values());
    }

    /**
     * 处理"/users/"的 POST 请求
     * <p>
     * "http://localhost:8080/users/"
     *
     * @param user 可以使用 @ModelAttribute 绑定参数，还可以通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    // public UserEntity postUser(@ModelAttribute UserEntity user) {
    // public UserEntity postUser(@RequestParam UserEntity user) {
    public UserEntity postUser(@RequestBody UserEntity user) {

        users.put(user.getId(), user);

        System.out.println("post add");
        System.out.println(user);

        return users.get(user.getId());
    }

    /**
     * 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
     * <p>
     * http://localhost:8080/users/1
     *
     * @param id user id
     * @return UserEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable Long id) {
        UserEntity userEntity = users.get(id);

        System.out.println(userEntity);

        return userEntity;
    }

    /**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     * <p>
     * "http://localhost:8080/users/1"
     *
     * @param id   user Id
     * @param user UserEntity
     * @return UserEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserEntity putUser(@PathVariable Long id, @RequestBody UserEntity user) {
        UserEntity entity = users.get(id);
        entity.setName(user.getName());
        entity.setAge(user.getAge());
        users.put(id, entity);
        return entity;
    }

    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     * <p>
     * "http://localhost:8080/users/1"
     *
     * @param id user Id
     * @return UserEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserEntity deleteUser(@PathVariable Long id) {
        return users.remove(id);
    }

}
