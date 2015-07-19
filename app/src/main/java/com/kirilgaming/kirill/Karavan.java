package com.kirilgaming.kirill;

import com.kirilgaming.kirill.activities.MainActivity;

public class Karavan {
    public int lvl;
    int gold;
    private MainActivity activity;

    public Karavan(MainActivity activity) {

        this.activity = activity;
    }

    public void printInfo() {
        activity.println("уровень коравана " + lvl + " золото коравана " + gold);
    }

    public void goldKaravan() {
        switch (lvl) {
            case 1:
                gold = 10;
                break;
            case 2:
                gold = 20;
                break;
            case 3:
                gold = 30;
                break;
            case 4:
                gold = 40;
                break;
            case 5:
                gold = 50;
                break;
        }
    }
}