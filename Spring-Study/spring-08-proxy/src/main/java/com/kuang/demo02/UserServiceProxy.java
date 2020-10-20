package com.kuang.demo02;

public class UserServiceProxy implements UserSerive {

    private UserServiceImpl userService ;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();

    }

    @Override
    public void delete() {
        userService.delete();
    }

    @Override
    public void update() {
        userService.update();
    }

    @Override
    public void query() {
        userService.query();

    }

    public void log(String msg){
        System.out.println("[debug] use" + msg);
    }
}
