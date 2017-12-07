package com.issexplorer.web;

import com.issexplorer.service.ConfigProperties4NotesBean;
import com.issexplorer.service.TestRandomConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ConfigProperties4NotesBean notesConfig;

    @Autowired
    private TestRandomConfigProperties randomConfigProperties;


    @RequestMapping("/")
    public String index() {
        return "Hello World!!!";
    }

    /**
     * 测试配置信息
     *
     * @return {"title":"iSSExplorer's Notes","subTitle":"Quick notes","desc":"iSSExplorer's Notes Quick notes"}
     */
    @RequestMapping("/configNotes")
    public ConfigProperties4NotesBean configNotes() {
        return notesConfig;
    }

    @RequestMapping("/configRandom")
    public TestRandomConfigProperties configRandom() {
        return randomConfigProperties;
    }

}
