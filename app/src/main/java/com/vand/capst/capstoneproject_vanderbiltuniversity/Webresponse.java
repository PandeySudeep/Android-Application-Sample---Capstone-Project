package com.vand.capst.capstoneproject_vanderbiltuniversity;

public class Webresponse {

    private String placeName;

    private Webresponse(String _name){
        this.placeName=_name;
    }

    public String getName(){
        return placeName;
    }
}