package cn.tuacy.spring.bean.definition.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/17 19:35.
 */
@Service
public class LogicService {

    private String holdInfo = "hold";

    public String getHoldInfo() {
        return holdInfo;
    }

    public void setHoldInfo(String holdInfo) {
        this.holdInfo = holdInfo;
    }

    @Override
    public String toString() {
        return "LogicService{" +
                "holdInfo='" + holdInfo + '\'' +
                '}';
    }
}
