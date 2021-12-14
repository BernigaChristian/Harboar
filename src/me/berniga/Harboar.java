package me.berniga;

import me.berniga.Exceptions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Harboar {
    private static final int MAX_BOATS=100;
    private Boat[] boats;

    public Harboar(){
        boats=new Boat[MAX_BOATS];
    }

    private int firstFree(int min,int max)  throws NoFreeSpaceException {
        for(int i=min;i<max;i++)
            if(boats[i]==null)  return i;
        throw new NoFreeSpaceException();
    }

    private int findPosition(double length,String type)  throws NoFreeSpaceException{
        try{
           return (length<10)?firstFree(0,20):((type.equalsIgnoreCase("vela"))? firstFree(50,MAX_BOATS): firstFree(20,50));
        }catch(NoFreeSpaceException e){
            return firstFree(0,MAX_BOATS);
        }
    }

    public double cost(int index,int days){
        Boat b=boats[index];
        return (b.getType().equalsIgnoreCase("vela"))?((10*b.getLength())*days):((20*b.getWeight())*days);
    }

    public void addBoat(Boat b){
        try{boats[findPosition(b.getLength(),b.getType())]=b;}
        catch(NoFreeSpaceException e){
            System.out.println(e.toString());
        }
    }

    public double removeBoat(int index,int days)    throws EmptyPositionException{
        try{
            double cost=cost(index,days);
            boats[index]=null;
            return cost;
        }catch(NullPointerException e){
            throw new EmptyPositionException();
        }
    }

    public Boat getBoat(int index)  throws EmptyPositionException{
        try{return boats[index];}
        catch(NullPointerException e){throw new EmptyPositionException();}
    }

    public ArrayList<String> getBoatsPerNationality(String nationality) throws NoNationalityException{
        ArrayList<String> natBoats=new ArrayList<String>();
        for(Boat b:boats)
            if(b.getNationality().equalsIgnoreCase(nationality))
                natBoats.add(b.getNationality());
        if(natBoats.size()==0)
            throw new NoNationalityException(nationality);
        return natBoats;
    }

    public void saveHarboar() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("out.txt"));
        for(int i=0;i<boats.length;i++){
            if(boats[i]!=null)  writer.write("position "+(i+1)+": "+boats[i].getName().toUpperCase()+"\n");
            else    writer.write("position "+(i+1)+": empty\n");
        }
            //writer.write((boats[i]==null)?("position "+(i+1)+": empty\n"):("position "+(i+1)+": "+boats[i].getName()+"\n"));
        writer.close();
    }






}
