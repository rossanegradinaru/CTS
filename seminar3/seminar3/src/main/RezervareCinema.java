package main;

import java.util.Date;

public class RezervareCinema implements Cloneable {
    String titlu;
    Date data_film;
    int[] rand;
    int[] loc;

    public RezervareCinema(String titlu, Date data_film, int[] rand, int[] loc) {
        this.titlu = titlu;
        this.data_film = data_film;
        this.rand = rand;
        this.loc = loc;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        RezervareCinema copy = (RezervareCinema) super.clone();
        copy.titlu = titlu;
        copy.data_film = data_film;
        copy.rand = rand;
        copy.loc = loc;
        return copy;
    }

    // public void add(int rand, int loc) {
    //     int lungime = this.rand.length;
    //     for (int i = 0; i < lungime; i++) {
    //         if (this.rand[i] == rand) {
    //             lungime++;
    //             this.rand[lungime] = loc;
    //         }
    //     }
    // }

    @Override
    public String toString() {

        return titlu + "," + data_film + "," + Arrays.toString(rand) + "," + Arrays.toString(loc);
    }

}