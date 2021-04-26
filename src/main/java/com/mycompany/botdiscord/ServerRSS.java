/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;

/**
 *
 * @author Bogdan
 */
public class ServerRSS {
    
    public ServerRSS() throws IOException, IllegalArgumentException, FeedException{
        String url = "https://stackoverflow.com/feeds/tag?tagnames=rome";
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        System.out.println(feed.getTitle());
    }

}
