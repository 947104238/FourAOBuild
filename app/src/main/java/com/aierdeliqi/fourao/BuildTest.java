package com.aierdeliqi.fourao;

import java.text.DecimalFormat;
import java.util.Random;

public class BuildTest {
    private StringBuffer test = null;
    // 最大值
    private int max;
    // 符号范围
    private String[] sym ;
    // 是否有括号
    private boolean hasPt = false;
    // 未匹配的左括号数量
    private int leftPt = 0;
    // 是否有小数
    private boolean hasSml = false;

    public BuildTest() {
        test = new StringBuffer();
        test.append("");
    }
    public void setSymbol(String []sym){
        this.sym = sym;
    }

    //接口 设置最大值
    public void setMax(int max) {
        this.max = max;
    }

    //接口 设置是否有括号
    public void setHasParenthese(boolean hasPt) {
        this.hasPt = hasPt;
    }

    //接口 设置是否有小数
    public void setHasSmallNum(boolean hasSml) {
        this.hasSml = hasSml;
    }

    // 接口 生成公式
    public StringBuffer buildTest() {
        setOrigin();
        Random random = new Random();
        int times = 5;
        for (int i = 1; i < random.nextInt(times); i++) {
            buildPt("left");
            buildElement();
            buildPt("right");
            buildConnect();
            buildPt("left");
        }
        buildElement();
        for (int i = 0; i < leftPt; i++) {
            test.append(")");
        }
        test.append("=");
        return test;
    }

    // 生成算式
    private void buildElement() {
        Random random = new Random();
        int a, b, symbol;
        double as,bs;
        a = random.nextInt(max);
        b = random.nextInt(max);
        symbol = random.nextInt(sym.length);
        if (hasSml) {
            DecimalFormat df = new DecimalFormat("0.00");
            as = a+random.nextDouble();
            bs = b+random.nextDouble();
            test.append(df.format(as) + sym[symbol] + df.format(bs) + "");
        } else {
            test.append(a + sym[symbol] + b + "");
        }
    }

    // 生成连接符
    private void buildConnect() {
        Random random = new Random();
        int symbol;
        symbol = random.nextInt(sym.length);
        test.append(sym[symbol]);
    }

    // 生成括号
    private void buildPt(String lor) {
        String[] ptLeft = { "", "(" };
        String[] ptRight = { "", ")" };
        Random random = new Random();
        // 当前是否是括号
        int prePt = 0;
        if (hasPt) {
            if (lor.equals("left")) {
                prePt = random.nextInt(2);
                test.append(ptLeft[prePt]);
                leftPt += prePt;
            } else {
                if (leftPt > 0) {
                    prePt = random.nextInt(2);
                    test.append(ptRight[prePt]);
                    leftPt -= prePt;
                }
            }
        }
    }

    // 得到公式
    private void setOrigin() {
        test.delete(0, test.length());
        leftPt = 0;
    }
}
