package me.berniga.Exceptions;

public class NoNationalityException extends Exception{
    private String nationality;

    public NoNationalityException(String nationality){
        this.nationality=nationality;
    }

    public String toString(){
        return "Sorry! There are no "+nationality+" boats in this harboar";
    }
}
