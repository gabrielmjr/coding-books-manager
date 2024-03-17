package com.mjr.terminal.codingbooksmanager;

import java.util.Scanner;

import com.mjr.terminal.codingbooksmanager.utils.ConfigsManager;

import static com.mjr.terminal.codingbooksmanager.options.ConstantOptions.MAIN;

public class Main {
    private Scanner scanner;
    private int userOption;
    private int currentOptions = MAIN;
    
	public static void main(String[] args) {
        new Main().run();
	}
    
    public void run() {
        initVariables();
        execute();
    }
    
    public void initVariables() {
        scanner = new Scanner(System.in);
    }
    
    public void execute() {
        
        ConfigsManager cm = ConfigsManager.getInstance();

        cm.getConfigs();
    }
}
