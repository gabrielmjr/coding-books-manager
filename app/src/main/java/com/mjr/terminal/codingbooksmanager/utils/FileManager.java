package com.mjr.terminal.codingbooksmanager.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static final String HOME_DIR = System.getProperty("user.home");
    public static final String MJRNEX_DIR = HOME_DIR + "/.mjrnex";
    public static final String INSTALLATION_DIR = MJRNEX_DIR + "/codingbooksmanager";
    
    public static FileManager instance;
    
    private File homeDir;
    protected File mjrNexDir;
    private File installationsDir;
    
    protected FileManager() {
        homeDir = new File(HOME_DIR);
        mjrNexDir = new File(MJRNEX_DIR);
        installationsDir = new File(INSTALLATION_DIR);
        if (!homeDir.exists()) {
            System.out.println("Error, Home dir doesn not exists");
            System.exit(1);
        }
        if (!mjrNexDir.exists())
            mjrNexDir.mkdir();
        if (!installationsDir.exists())
            installationsDir.mkdir();
    }
    
    public boolean write(String text, File file) throws IOException {
        if (!file.exists())
            file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
        return true;
    }
   
    public String read(File path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path.getAbsolutePath())));
    }
    
    public File getInstallationDir() {
        return installationsDir;
    }
    
    public static FileManager getInstance() {
        if (instance == null)
            instance = new FileManager();
        return instance;
    }
}
