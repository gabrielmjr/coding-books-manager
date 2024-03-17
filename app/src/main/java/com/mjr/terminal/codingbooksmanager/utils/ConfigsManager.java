package com.mjr.terminal.codingbooksmanager.utils;

import com.mjr.terminal.codingbooksmanager.models.Configs;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

public class ConfigsManager {
    private static ConfigsManager instance;
    private JsonManager jsonManager;
    
    private ConfigsManager() {
        jsonManager = jsonManager.getInstance();
    }
    
    public Configs getConfigs() {
        try {
            return jsonManager.readConfigs();
        } catch (IOException e) {
            jsonManager.createConfigsFile();
            return new Configs();
        }
    }
    
    public void saveConfigs(Configs Configs) {
        
    }
    
    public static ConfigsManager getInstance() {
        if (instance == null)
            instance = new ConfigsManager();
        return instance;
    }
}
