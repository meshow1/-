package com.kuang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener {
    @Override
    //每次创建session就会触发这个事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if(onlineCount==null){
            onlineCount=1;
        }else{
            onlineCount=onlineCount+1;
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }

    @Override
    //每次session销毁就会触发
    //两种情况会销毁，手动：session.invalidate()
    //自动销毁为配置xml下用session-config下设置销毁时间
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if(onlineCount==null){
            onlineCount=0;
        }else{
            onlineCount=onlineCount-1;
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }
}
