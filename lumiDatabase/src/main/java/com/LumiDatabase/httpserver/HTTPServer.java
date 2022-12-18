package com.LumiDatabase.httpserver;

import com.LumiDatabase.httpserver.config.Configuration;
import com.LumiDatabase.httpserver.config.ConfigurationManager;
import com.LumiDatabase.httpserver.core.ServerListenerThread;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class HTTPServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HTTPServer.class);
// left off on video 4, 8 minutes and 40 seconds

    public static void main(String[] args){

        LOGGER.info("Server starting...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
                                                                         //"src/main/resources/http.json"
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();


       LOGGER.info("Using Port: " + conf.getPort());

       LOGGER.info("Using webroot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
