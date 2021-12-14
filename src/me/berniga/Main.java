package me.berniga;

import me.berniga.Exceptions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void load(Harboar h){
        try{
            BufferedReader reader=new BufferedReader(new FileReader("in.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] splitted=line.split(";");
                h.addBoat(new Boat(splitted[0],splitted[1],Double.parseDouble(splitted[2]),Double.parseDouble(splitted[3]),splitted[4]));
            }
            reader.close();
        }catch(IOException e){System.out.println(e.toString());}
    }

    public static void simulate(Harboar h){
        for(int i=1;i<new Random().nextInt(10)+1;i++)
            if(new Random().nextInt(2)==0){
                try{System.out.println("cost ="+h.removeBoat(new Random().nextInt(100),i));}
                catch (EmptyPositionException e){System.out.println(e.toString());}
            }
        /*try{System.out.println("cost= "+h.removeBoat(20,5));}
        catch (EmptyPositionException e){System.out.println(e.toString());}*/
        try{h.saveHarboar();}
        catch(IOException e){System.out.println(e.toString());}
    }

    public static void main(String[] args) {
        Harboar h1=new Harboar();
        load(h1);
        simulate(h1);
    }
}
