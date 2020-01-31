package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Campus makeCampus() {
        Campus c = new Campus();
        c.addPath("Chapel", "Alumni", 2);
        c.addPath("Chapel", "Boys", 1);
        c.addPath("Chapel", "Cohen", 5);

        c.addPath("Alumni", "Admin", 4);
        c.addPath("Alumni", "Girls dorm", 3);

        c.addPath("Girls dorm", "VA", 1);
        c.addPath("Girls dorm", "Teacher's lot", 2);

        c.addPath("VA", "US classes", 1);

        c.addPath("US classes", "Teacher's lot", 1);
        c.addPath("US classes", "Admin", 1);

        c.addPath("Teacher's lot", "Security Gate", 3);

        c.addPath("Admin", "Senior lot", 2);
        c.addPath("Admin", "Security Gate", 1);

        c.addPath("Senior lot", "Security Gate", 1);

        c.addPath("Security Gate", "Rock", 1);

        c.addPath("Rock", "Cohen", 2);
        c.addPath("Rock", "Dining Hall", 3);

        c.addPath("Cohen", "Dining Hall", 2);

        c.addPath("Dining Hall", "Sci", 1);

        c.addPath("Sci", "Boys", 1);

        return c;
    }

    public static Campus makeRandomCampus() {
        Campus c = new Campus();
        c.addPath("Chapel", "Alumni", 1 + (int)(5*Math.random()));
        c.addPath("Chapel", "Boys", 1 + (int)(5*Math.random()));
        c.addPath("Chapel", "Cohen", 1 + (int)(5*Math.random()));

        c.addPath("Alumni", "Admin", 1 + (int)(5*Math.random()));
        c.addPath("Alumni", "Girls dorm", 1 + (int)(5*Math.random()));

        c.addPath("Girls dorm", "VA", 1 + (int)(5*Math.random()));
        c.addPath("Girls dorm", "Teacher's lot", 1 + (int)(5*Math.random()));

        c.addPath("VA", "US classes", 1 + (int)(5*Math.random()));

        c.addPath("US classes", "Teacher's lot", 1 + (int)(5*Math.random()));
        c.addPath("US classes", "Admin", 1 + (int)(5*Math.random()));

        c.addPath("Teacher's lot", "Security Gate", 1 + (int)(5*Math.random()));

        c.addPath("Admin", "Senior lot", 1 + (int)(5*Math.random()));
        c.addPath("Admin", "Security Gate", 1 + (int)(5*Math.random()));

        c.addPath("Senior lot", "Security Gate", 1 + (int)(5*Math.random()));

        c.addPath("Security Gate", "Rock", 1 + (int)(5*Math.random()));

        c.addPath("Rock", "Cohen", 1 + (int)(5*Math.random()));
        c.addPath("Rock", "Dining Hall", 1 + (int)(5*Math.random()));

        c.addPath("Cohen", "Dining Hall", 1 + (int)(5*Math.random()));

        c.addPath("Dining Hall", "Sci", 1 + (int)(5*Math.random()));

        c.addPath("Sci", "Boys", 1 + (int)(5*Math.random()));

        return c;


    }

    public static void main(String[] args) {
	// write your code here
        Campus c = makeCampus();
        Campus cRand = makeRandomCampus();
        System.out.println(c.getPaths("Chapel"));
        System.out.println(c.getPaths("Alumni"));
        System.out.println(c.getPaths("Girls dorm"));
        System.out.println(c.getPaths("VA"));
        System.out.println(c.getPaths("US classes"));
        System.out.println(c.getPaths("Teacher's lot"));
        System.out.println(c.getPaths("Senior lot"));
        System.out.println(c.getPaths("Security Gate"));
        System.out.println(c.getPaths("Dining Hall"));
        System.out.println(c.getPaths("Rock"));
        System.out.println(c.getPaths("Admin"));
        System.out.println(c.getPaths("Cohen"));
        System.out.println(c.getPaths("Sci"));
        System.out.println(c.getPaths("Boys"));
        ArrayList<String> normalPath = c.doDijkstra("Girls dorm", "Rock");
        System.out.println("Regular: " + normalPath);
        ArrayList<String> randPath = cRand.doDijkstra("Girls dorm", "Rock");
        System.out.println("Random: " + randPath);
        String current = "Security Gate";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("You are at the "+ current);
            System.out.println(c.getPaths(current));
            String to = sc.nextLine();
            if(c.goesTo(current, to)) {
                current = to;
            }
        }
    }
}
