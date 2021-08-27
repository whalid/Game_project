package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File read = new File("movie.txt");
        Scanner movie_scan = new Scanner(read);

        int count = 0;       //to count movie numbers
        String[] title = new  String[200];    //to get movies name into a string
        while (movie_scan.hasNextLine()){
            count++;
            title[count] = movie_scan.nextLine();
        }
        int random =(int)(Math.random()*count+1);  //generate random number to pick random movie
        int title_length = title[random].length();   //length of the random movie

        String guess = "";   //string only contains "_____..."
        String wrong_letters = "";
        int i,chance = 10,point = 0,space = 0;
        boolean same;
        for(i=0;i<title_length;i++)
        {
            if(title[random].charAt(i) == ' ')
            {
                guess += ' ';
                space++;
            }
            else
                guess += '_';
        }

        point = space;
        Scanner inputScan = new Scanner(System.in);
        char input;

        while (chance >0 && point < title_length){
            System.out.println("You are guessing : "+guess);
            System.out.println("You have guessed ("+chance+") wrong letters :"+wrong_letters);
            System.out.print("Guess a letter : ");
            same = false;
            input = inputScan.next().charAt(0);
            //System.out.println(input);
            for(i=0;i<title_length; i++) {
                if (title[random].charAt(i) == input) {
                    same = true;
                    if(guess.charAt(i) == '_')
                        point++;
                    guess = guess.substring(0,i)+input+guess.substring(i+1,title_length);
                }
            }
            if(!same)
            {
                chance--;
                wrong_letters += (" " + input);
            }
        }
        if(chance > 0)
            System.out.println("You Win!\nYou have guessed '"+guess+"' correctly.");
        else
            System.out.println("You Loss!");
    }
}
