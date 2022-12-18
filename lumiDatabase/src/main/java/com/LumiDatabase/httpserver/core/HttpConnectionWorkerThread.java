package com.LumiDatabase.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread{

    private Socket socket;
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            int _byte = inputStream.read();
            while((_byte = inputStream.read()) >= 0){
                System.out.print((char)_byte);
            }
            //TODO we would read

            //TODO we would do writing
            String html = "<html><head><title>Luiz's Simple Java HTTP Server</title></head><body><h1> This page was served using Luiz's simple Java HTTP server</h1></body></html>";

            final String CRLF = "\n"; // 13,10
            String response =
                    "HTTP/1.1 200 OK" + CRLF + // Status line : HTTP VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            "Content-Length: " + html.getBytes().length + CRLF + // HEADER
                            CRLF +
                            html +
                            CRLF + CRLF;

            outputStream.write(response.getBytes());



            LOGGER.info("Connection Processing Finished");

        } catch (IOException e) {
            LOGGER.error("Problem with communication", e);
            e.printStackTrace();
        } finally {
            if(inputStream!= null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {

                }
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
