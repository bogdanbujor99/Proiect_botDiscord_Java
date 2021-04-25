/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author crist
 */
public class Commands extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event){
        String args = event.getMessage().getContentRaw();
        
        if(args.equalsIgnoreCase("cum e vremea?")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Este frumos afara, " + event.getAuthor().getName()).queue();
        }
    }
    
}
