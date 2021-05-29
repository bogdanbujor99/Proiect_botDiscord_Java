/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 *
 * @author Bogdan
 */
public class Main {

    public static void main(String[] args) throws LoginException, IOException, IllegalArgumentException, FeedException {
        JDA jda = JDABuilder.createDefault("ODMyOTA0MTEyMjQwMDY2NTkw.YHqkZg.HhgzPEHjiSu6lKSSEJRIv-MGji0").build();
        jda.getPresence().setActivity(Activity.watching("himself get coded"));
        jda.addEventListener(new Commands(jda));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
    }
}
