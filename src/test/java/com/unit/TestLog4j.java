package com.unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

/**
 * @Author: Richered
 * @Date: 2019/11/27 17:30
 * Description:
 */
public class TestLog4j {
    private static final Logger logger = LoggerFactory.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
