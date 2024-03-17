package com.mjr.terminal.codingbooksmanager.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjr.terminal.codingbooksmanager.models.Configs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class JsonManager extends FileManager {
    private static JsonManager instance;
    
    private ObjectMapper mapper;
    public File configPath;
    
    protected JsonManager() {
        super();
        mapper = new ObjectMapper();
        configPath = new File(getInstallationDir(), "/config.json");
    }
    
    public boolean write(Object obj, File file) {
        try {
            write(mapper.writeValueAsString(obj), file);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public Object read(File file, Class c) {
        try {
            return mapper.readValue(file, c);
        } catch (IOException e) {
            return null;
        }
    }
    
    public boolean createConfigsFile() {
        if (configPath.exists())
            configPath.delete();
        try {
            return configPath.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }
    
    public Configs readConfigs() throws FileNotFoundException, IOException {
        if (!configPath.exists())
            throw new FileNotFoundException();
        return (Configs)read(configPath, Configs.class);
    }
    
    public static JsonManager getInstance() {
        if (instance == null)
            instance = new JsonManager();
        return instance;
    }
}
