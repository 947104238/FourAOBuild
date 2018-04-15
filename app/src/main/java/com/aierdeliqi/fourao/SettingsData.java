package com.aierdeliqi.fourao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

public class SettingsData implements Serializable{
    private String textnums,maxnum;
    private Set<String>symbol;
    private boolean parentheses,smallnum,printlocal;

    public SettingsData() {
    }

    public SettingsData(String textnums, String maxnum, Set<String> symbol, boolean parentheses, boolean smallnum, boolean printlocal) {
        this.textnums = textnums;
        this.maxnum = maxnum;
        this.symbol = symbol;
        this.parentheses = parentheses;
        this.smallnum = smallnum;
        this.printlocal = printlocal;
    }

    public String getTextnums() {
        return textnums;
    }

    public void setTextnums(String textnums) {
        this.textnums = textnums;
    }

    public String getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(String maxnum) {
        this.maxnum = maxnum;
    }

    public Set<String> getSymbol() {
        return symbol;
    }

    public void setSymbol(Set<String> symbol) {
        this.symbol = symbol;
    }

    public boolean isParentheses() {
        return parentheses;
    }

    public void setParentheses(boolean parentheses) {
        this.parentheses = parentheses;
    }

    public boolean isSmallnum() {
        return smallnum;
    }

    public void setSmallnum(boolean smallnum) {
        this.smallnum = smallnum;
    }

    public boolean isPrintlocal() {
        return printlocal;
    }

    public void setPrintlocal(boolean printlocal) {
        this.printlocal = printlocal;
    }
}
