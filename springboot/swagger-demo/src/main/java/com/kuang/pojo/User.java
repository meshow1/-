package com.kuang.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


//将pojo绑定到swagger页面的model分组中，只需要接口中存在实体类就可以被扫描到
//此处在controller中用到了User类
//@Api()//用于类，表示标识这个类是swagger的资源
@ApiModel("用户实体类")//给接口加注释
public class User {

    @ApiModelProperty("用户名")//给参数加注释
    public String username;
    @ApiModelProperty("密码")
    public String password;
}
