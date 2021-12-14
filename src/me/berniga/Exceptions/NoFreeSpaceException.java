package me.berniga.Exceptions;

public class NoFreeSpaceException extends Exception{
    public NoFreeSpaceException(){super();}

    public String toString(){return "There are no free parking spots\nPLEASE WAIT!!";}
}
