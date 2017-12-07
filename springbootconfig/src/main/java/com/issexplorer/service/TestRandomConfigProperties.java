package com.issexplorer.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test-random.properties")
@ConfigurationProperties(prefix = "issexplorer.notes.random")
public class TestRandomConfigProperties {

    private String value;
    private String number;
    private long bigNumber;
    private int count;
    private int rankNumber;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }
}
