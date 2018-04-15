package com.aierdeliqi.fourao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Set;

public class SettingActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener,Preference.OnPreferenceClickListener{
    private EditTextPreference set_textnums;
    private MultiSelectListPreference set_symbol;
    private SwitchPreference set_parentheses,set_smallnum,set_printlocal;
    private ListPreference set_printer,set_maxnum;
    private Preference build,saveToLocal,printer;
    private Toolbar toolbar;
    private AppCompatDelegate delegate;



    public void find(){
        set_textnums = (EditTextPreference) findPreference("set_textnums");
        set_symbol = (MultiSelectListPreference)findPreference("set_symbol");
        set_parentheses = (SwitchPreference)findPreference("set_parentheses");
        set_smallnum = (SwitchPreference)findPreference("set_smallnum");
        set_printlocal = (SwitchPreference)findPreference("set_printlocal");
        set_printer = (ListPreference)findPreference("set_printer");
        set_maxnum = (ListPreference)findPreference("set_maxnum");
        build = (Preference)findPreference("build");
        saveToLocal = (Preference)findPreference("saveToLocal");
        printer = (Preference)findPreference("printer");
    }

    public void setListener(){
        build.setOnPreferenceClickListener(this);
        saveToLocal.setOnPreferenceClickListener(this);
    }


    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_toolbar);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("设置");
        setSupportActionBar(toolbar);
        addPreferencesFromResource(R.xml.preferences);
        find();
        setListener();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    public void savePreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SettingsData data = new SettingsData();
        data.setMaxnum(sp.getString("set_maxnum","10"));
        data.setParentheses(sp.getBoolean("set_parentheses",false));
        data.setPrintlocal(sp.getBoolean("set_printlocal",false));
        data.setSmallnum(sp.getBoolean("set_smallnum",false));
        data.setTextnums(sp.getString("set_textnums","10"));
        data.setSymbol(sp.getStringSet("set_symbol",null));
        Intent intent = new Intent(SettingActivity.this,TestActivity.class);
        intent.putExtra("data",data);
//        Toast.makeText(this, ""+set_textnums.getText(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return true;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == build) {
            savePreferences();
        }
        return true;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getDelegate().setContentView(layoutResID);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }
    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    private void setSupportActionBar(Toolbar toolbar){
        getDelegate().setSupportActionBar(toolbar);
    }

    private AppCompatDelegate getDelegate(){
        if (delegate == null){
            delegate = AppCompatDelegate.create(this,null);
        }
        return delegate;
    }
}
