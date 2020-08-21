package com.company;

import java.util.Map;
import java.util.Random;

class Move {
    int roll(String name, int start, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        int position;
        Random rand = new Random();
        int move = 1 + rand.nextInt(6);
        if(ladders.containsKey(start + move))
            position = ladders.get(start + move);

        else if (snakes.containsKey(start + move))
            position = snakes.get(start + move);

        else {
            position = start + move;
            if (position > 100)
                position = start;
        }
        System.out.println(name + " rolled a " + move + " and moved from " + start + "to " + position);
        return position;
    }
}
