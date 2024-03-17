package com.mjr.terminal.codingbooksmanager.options;

import java.io.File;

public class OptionsLoader {
    private static final String LANGS_DIR = "/langs";
    private static final String ENGLISH = "/en";
    private static final String OPTIONS_DIR = "/options";
    
    
    public String loadOptions() {
        File optionsFile = loadOptionsFile();
        return null;
    }
    
    public File loadOptionsFile() {
        return new File(ClassLoader.getSystemClassLoader()
            .getResource("").getFile());
    }
}
