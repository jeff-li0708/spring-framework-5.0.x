package com.liangzai.config;

import com.liangzai.register.MyMapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangl on 2019/9/9.
 */
@Configuration
@MyMapperScan("com.liangzai.dao") //扫描指定的包
public class AppConfig {
}
