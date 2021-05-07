/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
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
    boolean okTema = false;
    
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
            event.getChannel().sendMessage("Alege o tema, " + event.getAuthor().getName() + "!").queueAfter(500, TimeUnit.MILLISECONDS);
            event.getChannel().sendMessage("1. Java\n 2. C++\n 3. Programare").queueAfter(1, TimeUnit.SECONDS);
            ok = true;
        }
        
        else if(ok){
            if(args.equalsIgnoreCase("Java")){
                event.getChannel().sendMessage("Tema Java a fost aleasa!\n Astept intrebarile.").queueAfter(1, TimeUnit.SECONDS);
                okTema = true;
            }
            System.out.println(args);
            if(okTema && !args.equalsIgnoreCase("java") && !args.equalsIgnoreCase("c++") && !args.equalsIgnoreCase("programare") && !event.getAuthor().getName().equalsIgnoreCase("discordbotjava")){
                    System.out.println(args);
                    try {
                        ServerRSS server = new ServerRSS();
                        String answer = server.searchQuestion(args);
                        event.getChannel().sendMessage(answer).queueAfter(1, TimeUnit.SECONDS);
                    } catch (IOException ex) {
                        Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FeedException ex) {
                        Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
    }
}
