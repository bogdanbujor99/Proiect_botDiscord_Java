/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import static java.lang.Thread.sleep;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author crist
 */
public class Commands extends ListenerAdapter{
    JDA jda;
    Messages message;
    boolean ok = false;
    
    public Commands(JDA jda){
        this.jda = jda;
    }

    /**
     *
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String args = event.getMessage().getContentRaw();
        
        if(args.equalsIgnoreCase("Salut, botDiscord")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Alege o tema, " + event.getAuthor().getName() + "!").queueAfter(1, TimeUnit.SECONDS);
            ok = true;
        }
        
        else if(ok){
            
        }
    }
}
