/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
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
    List<User> users = new ArrayList<>();
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
            event.getChannel().sendMessage("1. Java\n2. C++\n3. Programare").queueAfter(1, TimeUnit.SECONDS);
            users.add(new User(event.getAuthor().getName()));
            users.get(0).setInit(true);
            ok = true;
        }
        else if(users.get(0).getInit()){
            if(args.equalsIgnoreCase("Java")){
                event.getChannel().sendMessage("Tema Java a fost aleasa!\n Astept intrebarile.").queueAfter(1, TimeUnit.SECONDS);
                users.forEach(i->{
                    System.out.println(i.getName());
                });
                okTema = true;
            }
            else if(args.equalsIgnoreCase("C++")){
                event.getChannel().sendMessage("Tema C++ a fost aleasa!\n Astept intrebarile.").queueAfter(1, TimeUnit.SECONDS);
                okTema = true;
            }
            else if(args.equalsIgnoreCase("Programare")){
                event.getChannel().sendMessage("Tema programare a fost aleasa!\n Astept intrebarile.").queueAfter(1, TimeUnit.SECONDS);
                okTema = true;
            }
            else if(okTema && !args.equalsIgnoreCase("java") && !args.equalsIgnoreCase("c++") && !args.equalsIgnoreCase("programare") && !event.getAuthor().getName().equalsIgnoreCase("discordbotjava")){
                    System.out.println(args);
                    try {
                        ServerRSS server = new ServerRSS();
                        String answer = server.searchQuestionJava(args);
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
