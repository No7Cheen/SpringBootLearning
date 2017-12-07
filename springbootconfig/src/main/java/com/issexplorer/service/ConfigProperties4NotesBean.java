package com.issexplorer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义 Notes 配置
 * <p>
 * 添加 @Component 注解，让 Spring 在启动的时候扫描到该类，并添加到 Spring 容器中
 */
@Component
public class ConfigProperties4NotesBean {

    @Value("${issexplorer.notes.title}")
    private String title;

    @Value("${issexplorer.notes.subTitle}")
    private String subTitle;

    @Value("${issexplorer.notes.desc}")
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
