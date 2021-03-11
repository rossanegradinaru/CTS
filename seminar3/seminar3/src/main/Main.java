package main;

import writers.FileWriter;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        RezervareCinema r1=new RezervareCinema("film1",new Date(),new int[]{1,2,3},new int[]{1,2,3,4,5});

        FileWriter outFile = new FileWriter();
        outFile.write(r1.titlu);


  }
}


