package com.mjr.terminal.codingbooksmanager.models;

import com.mjr.terminal.codingbooksmanager.utils.ConfigsManager;

public class Configs {
    private String lang;
    
    public void save() {
        ConfigsManager.getInstance().saveConfigs(this);
    }
}
