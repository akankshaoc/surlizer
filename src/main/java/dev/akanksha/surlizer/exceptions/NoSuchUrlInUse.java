package dev.akanksha.surlizer.exceptions;

public class NoSuchUrlInUse extends Exception{
    public NoSuchUrlInUse(String url) {
        super("url : " + url + "is not registered with surlizer");
    }
}
