package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int amtPlayers;
        do {
            System.out.println("Enter the amount of players playing:");
            amtPlayers = amtPlayersIn();
            if (amtPlayers > -1) {
                amtPlayers += 1;
                break;
            }
        } while (true);
        int indexPlayer;
        String[] placeholders = new String[(amtPlayers * 2) + 1];
        int[] playerScore = new int[amtPlayers];
        Random rand = new Random();
        int indexComputer;

        for (int i = 0; i < (3); i++) {
            for (int j = 0; j < amtPlayers; j++) {
                if (j != (amtPlayers - 1)) {
                    do {
                        System.out.println("Player " + (j + 1) + " enter a number:");
                        indexPlayer = numInput();
                        if (indexPlayer != -1) {
                            break;
                        }
                    } while (true);
                    if (placeholders[indexPlayer] == null) {
                        placeholders[indexPlayer - 1] = Integer.toString(j);
                    }
                }
                else {
                    indexComputer = rand.nextInt((amtPlayers * 2) + 1);
                    if (placeholders[indexComputer] == null) {
                        placeholders[indexComputer] = "C";
                    }
                }
            }
        }
        for (int i = 0; i < placeholders.length; i++) {
            for (int j = 0; j < amtPlayers; j++) {
                if (j != (amtPlayers - 1)) {
                    if (placeholders[i] != null) {
                        if (placeholders[i].equals(Integer.toString(j))) {
                            playerScore[j] = playerScore[j] + 1;
                        }
                    }
                }
                else {
                    if (placeholders[i] != null) {
                        if (placeholders[i].equals("C")) {
                            playerScore[j] += 1;
                        }
                    }
                }
            }
        }
        System.out.println("Here are the scores:");
        for (int i = 0; i < amtPlayers; i++) {
            if (i != (amtPlayers - 1)) {
                System.out.println("Player " + (i + 1) + " got " + playerScore[i]);
            }
            else {
                System.out.println("The computer got " + playerScore[i]);
            }
        }
    }
    public static int numInput() {
        Scanner input = new Scanner(System.in);
        try {
            int userIn = input.nextInt();
            if (userIn > 0 && userIn < 10) {
                return userIn;
            }
            else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Enter a valid input");
            return -1;
        }
    }
    public static int amtPlayersIn() {
        Scanner input = new Scanner(System.in);
        try {
            int userIn = input.nextInt();
            if (userIn > 0) {
                return userIn;
            }
            else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Enter a valid input");
            return -1;
        }
    }
}
