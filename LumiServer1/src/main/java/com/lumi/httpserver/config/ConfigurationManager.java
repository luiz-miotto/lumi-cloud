package com.lumi.httpserver.config;

public class ConfigurationManager {
private static ConfigurationManager myConfigurationManager;
private static Configuration myCurrentConfiguration;


    private ConfigurationManager(){

    }

    private static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /*
    *Used to load a configuration file by the path provided
    *
    */

    public void loadConfigurationFile(String filePath){

    }

    /*
    *
    * Returns the current loaded configuration
    *
     */

    public void getCurrentConfiguration(){

    }
}
