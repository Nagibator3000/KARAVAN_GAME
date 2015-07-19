package com.kirilgaming.kirill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args) throws IOException

    {
       /* while (true) {
            Karavan karavan = new Karavan();
            karavan.lvl = (int) (Math.random() * 5 + 1);
            karavan.goldKaravan();
            karavan.printInfo();
            System.out.println(" хотите его ограбить?");
            String userInput = getInputString();
            if (userInput.toUpperCase().equals("Y")) { //TODO добавить несколько действий на манер "1) атаковать 2) не атаковать 3) пойти в магазин и т.д."
                player.rob(karavan);
                //TODO добвить логику о вероятностной победе над корованом и записывать результат сражения в объект корована
            } else {
                player.respect = player.respect + karavan.lvl;
            }
            karavansList.add(karavan);
            player.gold -= 3;
            player.lvlup();
            player.printInfo();
            if (player.respect < 0) break;
            System.out.println();
            if (player.gold < 0) break;
        }
        System.out.println("___GAME OVER___");
        System.out.println("SPisok karavanov");
        for (Karavan karavan : karavansList) {
            karavan.printInfo();     //TODO выводить резуьтат боя
        }*/

    }


    private static String getInputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
