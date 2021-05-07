/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

/**
 *
 * @author Bogdan
 */
public class User {
    private String name;
    private boolean init = false;
    private boolean chooseTheme = false;
    private String theme;
    
    User(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public void setChooseTheme(boolean chooseTheme) {
        this.chooseTheme = chooseTheme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public boolean isInit() {
        return init;
    }

    public boolean isChooseTheme() {
        return chooseTheme;
    }

    public String getTheme() {
        return theme;
    }

    boolean getInit() {
        return init;
    }
    
    
    
}
