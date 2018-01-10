package com.vand.capst.capstoneproject_vanderbiltuniversity;

/**
 * Created by Sudeep.Pandey on 1/10/2018.
 */


public class Webresponse {

    private String name;

  /*
    public static final Webresponse[] responsesFromWeb = {

            new Webresponse("first response"),new Webresponse("Second Response is the second response"),
            new Webresponse("Third Response"),new Webresponse("Fourth Response"),
            new Webresponse("Fifth Response is half way around. Sixth response follows."),new Webresponse("Sixth Response"),
            new Webresponse("Seventh Response"),new Webresponse("Eighth Response"),
            new Webresponse("Ninth Response"),new Webresponse("Tenth Response from HTTP Web service call via GET request.")
    };
    */

    private Webresponse(String _name){
        this.name=_name;
    }

    public String getName(){
        return name;
    }
}
