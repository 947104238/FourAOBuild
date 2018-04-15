package com.aierdeliqi.fourao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestActivity extends AppCompatActivity {
    private String textnums,maxnum;
    private int num,max;
    private Set<String>symbol;
    private boolean parentheses,smallnum,printlocal;
    StringBuffer s ;
    String []symbols = {"+","-","*","/"};
    String []preSymbol;
    private LinkedList<Tests>mData = null;
    private TestsAdapter testsAdapter = null;
    private Context context;
    private ListView lv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        context = TestActivity.this;
        lv_test = findViewById(R.id.lv_test);
        SettingsData data = (SettingsData)getIntent().getSerializableExtra("data");
        textnums = data.getTextnums();
        maxnum = data.getMaxnum();
        symbol = data.getSymbol();
        parentheses = data.isParentheses();
        smallnum = data.isSmallnum();
        printlocal = data.isPrintlocal();
        num = Integer.parseInt(textnums);
        max = Integer.parseInt(maxnum);


        Iterator<String> arr = symbol.iterator();
        preSymbol = new String[symbol.size()];
        int j=0;
        while (arr.hasNext()){
            preSymbol[j] = symbols[Integer.parseInt(arr.next())];
            j++;
        }
//        Toast.makeText(TestActivity.this, "j:"+j+" sym"+symbol.size(), Toast.LENGTH_SHORT).show();




//        s.append("题目数量"+textnums+"\n")
////                .append("最大值"+maxnum+"\n")
////                .append("符号"+ symbol+"\n")
////                .append("括号"+parentheses+"\n")
////                .append("小数"+smallnum+"\n")
////                .append("打印"+printlocal+"\n");

        mData = new LinkedList<>();

        BuildTest buildTest = new BuildTest();
        buildTest.setHasParenthese(parentheses);
        buildTest.setHasSmallNum(smallnum);
        buildTest.setMax(max);
        buildTest.setSymbol(preSymbol);
        num = 50;
        for (int i=1;i<=num;i++) {
            s = new StringBuffer();
            s.append(i+"、   ");
            s.append(buildTest.buildTest());
            mData.add(new Tests(s));
        }
        testsAdapter = new TestsAdapter(mData,context);
        lv_test.setAdapter(testsAdapter);
    }
}
