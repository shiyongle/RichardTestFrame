package com.crazyjava;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * @Author: Richered
 * @Date: 2020/08/02 17:55
 * @Description:
 **/
public class NumberListModel extends AbstractListModel<BigDecimal> {
    protected BigDecimal start;

    protected BigDecimal end;

    protected BigDecimal step;

    public NumberListModel(double start, double end, double step){
        this.start = BigDecimal.valueOf(start);
        this.end = BigDecimal.valueOf(end);
        this.step = BigDecimal.valueOf(step);
    }

    @Override
    public int getSize() {
        return (int)Math.floor(end.subtract(start).divide(step).doubleValue() + 1);
    }

    @Override
    public BigDecimal getElementAt(int index) {
        return BigDecimal.valueOf(index).multiply(step).add(start);
    }
}
