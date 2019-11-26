package com.ydl.testcase;

import com.ydl.page.App;
import com.ydl.page.EvaluationPage;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 17:31
 * Description:测评用例
 */
public class TestEvaluation {
    public static EvaluationPage evaluationPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        evaluationPage = App.toEvaluationPage();
    }
}
