package com.kuang.demo01;

public class Proxy {
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }
    public Proxy() {
    }

    public void rent(){
        seeHost();
        host.rent();
        heTong();
        fare();
    }
    public void seeHost(){
        System.out.println("seehouse");
    }
    public void heTong(){
        System.out.println("qianhetong");
    }
    public void fare(){
        System.out.println("shoufei");
    }



}
