package snakeAndLadder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    int rollDie;
    int currentPosition;

    Map<Integer, Integer> snakeHead = new HashMap();
    {
        snakeHead.put(17, 7);
        snakeHead.put(54, 34);
        snakeHead.put(62, 19);
        snakeHead.put(87, 36);
        snakeHead.put(92, 75);
        snakeHead.put(95, 75);
        snakeHead.put(98, 77);
    }

    Map<Integer, Integer> ladderEnd = new HashMap<>();
    {
        ladderEnd.put(1, 38);
        ladderEnd.put(4, 14);
        ladderEnd.put(9, 31);
        ladderEnd.put(21, 42);
        ladderEnd.put(28, 84);
        ladderEnd.put(51, 67);
        ladderEnd.put(72, 91);
        ladderEnd.put(80, 99);
    }





    Player(int rollDie){
        this.rollDie = rollDie;

        if (rollDie < 6){
            System.out.println("Roll the die Again...");
            System.out.println("---------------------");
            System.out.println("You need to roll a 6");
        }
        else if (rollDie == 6){
            System.out.println("Your game has started!");
            System.out.println(" ---- Roll again ---- ");
        }
        else if (rollDie > 6){
            System.out.println("~~~~~~~ Woah! that number is waaaaay too big for a die ~~~~~");
        }
//
//        if (rollDie >= 1 && rollDie <= 6){
//            currentPosition += rollDie;
//        }
//        else{
//            System.out.println("Enter a valid number on the die");
//        }
    }

    void rollDie(int rollNumber){
        boolean validInput = (rollNumber >= 1 && rollNumber <= 6);

        if (validInput){
            currentPosition += rollNumber;
        }
        else{
            System.out.println("Enter a valid number on the die");
        }
    }

    public int getCurrentPosition() {

        if (currentPosition == 100){
            System.out.println("Game Over - You have WON!");
        }
        else if (currentPosition > 100){
            System.out.println();
        }

        if (snakeHead.get(currentPosition) != null){
            System.out.println("You're going DOWN the snake head :(");
            currentPosition = snakeHead.get(currentPosition);
        }

        if (ladderEnd.get(currentPosition) != null){
            System.out.println("You're going UP the ladder :)");
            currentPosition = ladderEnd.get(currentPosition);
        }
        System.out.println("Your current position is: " + currentPosition);
        System.out.println("----------------------------------------------");
        return currentPosition;
    }
}
