package com.company;
import java.util.*;

class Game {
    // method for scanning snakes and ladders input
    private static Map<Integer, Integer> scanInput(){
        Scanner obj = new Scanner(System.in);
        int noOfItems = obj.nextInt();
        HashMap<Integer,Integer> itemMap = new HashMap<>(noOfItems);
        for(int i =0; i<noOfItems; i++){
            Integer start = obj.nextInt();
            Integer end = obj.nextInt();
            itemMap.put(start, end);
        }
//        System.out.println(itemMap);
        return itemMap;
    }
    public static void main(String[]args){

        Map<Integer, Integer> snakes = scanInput();
        Map<Integer, Integer> ladders = scanInput();

        //players
        Scanner players = new Scanner(System.in);
        int noOfPlayers = players.nextInt();
        String[] names = new String[noOfPlayers];
        for(int i=0; i<noOfPlayers; i++) {
            names[i] = players.next();
        }

        int[] currentPosition = new int[noOfPlayers];
        Move playerMove= new Move();
        int afterMove;

        while(true) {
            boolean trigger = false;
            for (int i = 0; i < noOfPlayers; i++) {
                afterMove = playerMove.roll(names[i], currentPosition[i], snakes, ladders);
                currentPosition[i] = afterMove;
                if (currentPosition[i] == 100) {
                    System.out.println(names[i] + " wins the game");
                    trigger = true;
                    break;
                }
            }
            if (trigger)
                break;
        }
    }
}
