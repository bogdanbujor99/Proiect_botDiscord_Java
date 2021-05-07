/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Bogdan
 */
public class ServerRSS {
    SyndFeed feed;
    
    
    public ServerRSS() throws IOException, IllegalArgumentException, FeedException{
        File file = new File("D:\\Facultate\\An2 Sem2\\PA\\Proiect_botDiscord_Java\\src\\main\\java\\com\\mycompany\\botdiscord\\IntrebariJava.xml");
        //String url = "https://stackoverflow.com/feeds/tag?tagnames=rome";
        feed = new SyndFeedInput().build(new XmlReader(file));
//        System.out.println(feed.getEntries().get(1).getTitle());
        
    }

    public String searchQuestion(String question){
        for(SyndEntry entry : feed.getEntries()){
            if(entry.getTitle().equals(question)){
                return entry.getDescription().getValue();
            }
        }
        return "Intrebare gresita";
    }
}
