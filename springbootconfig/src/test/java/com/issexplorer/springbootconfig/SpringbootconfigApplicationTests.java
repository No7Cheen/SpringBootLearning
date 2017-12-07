package com.issexplorer.springbootconfig;

import com.issexplorer.service.ConfigProperties4NotesBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootconfigApplicationTests {

    @Autowired
    private ConfigProperties4NotesBean notesConfig;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testConfigNotes() throws Exception {
        Assert.assertEquals(notesConfig.getTitle(), "iSSExplorer's Notes");
        Assert.assertEquals(notesConfig.getSubTitle(), "Quick notes");
        Assert.assertEquals(notesConfig.getDesc(), "iSSExplorer's Notes Quick notes");
    }

    @Test
    public void testConfigRandom() throws Exception {
        System.setOut(new PrintStream("testRandomConfig"));
        //        System.setOut(new PrintStream(randomConfig.value + ""));
        //        System.setOut(new PrintStream(randomConfig.count + ""));
    }

}
