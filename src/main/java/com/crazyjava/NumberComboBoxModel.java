package com.crazyjava;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * @Author: Richered
 * @Date: 2020/08/02 17:59
 * @Description:
 **/
public class NumberComboBoxModel extends NumberListModel implements ComboBoxModel<BigDecimal> {

    private int selectId = 0;

    public NumberComboBoxModel(double start, double end, double step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal){
            BigDecimal target = (BigDecimal) anItem;
            selectId = target.subtract(super.start).divide(step).intValue();
        }
    }

    @Override
    public BigDecimal getSelectedItem() {
        return BigDecimal.valueOf(selectId).multiply(step).add(start);
    }
}
