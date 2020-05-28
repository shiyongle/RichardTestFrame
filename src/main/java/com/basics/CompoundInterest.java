package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/5/19 20:13
 * Description:
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        double[] interestRate = new double[NRATES];

        for (int j = 0; j < interestRate.length; j++){
            interestRate[j] = (STARTRATE + j) /100.0;
            //saasda
        }

        double[][] balances = new double[NYEARS][NRATES];
        for (int j = 0; j < balances[0].length; j++){
            balances[0][j] = 1000;
        }
        for (int i = 1; i < balances.length; i++){
            for (int j =0; j < balances[i].length; j++){
                double oldBalance = balances[i - 1][j];
                double interest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + interest;
            }
        }
    }
}
