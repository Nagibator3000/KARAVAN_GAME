package com.kirilgaming.kirill;

import com.kirilgaming.kirill.activities.MainActivity;

public class Player {
    public int lvl;
    public int exp;
    public int expForNextLvlUp;
    public String name;
    public int gold;
    public int respect;
    private MainActivity activity;

    public Player(MainActivity act) {

        this.activity = act;
    }

    public void printInfo() {
        activity.println(name);
        activity.println(exp + " exp " + lvl + " уровень");
        activity.println("Ваше богатсво " + gold + " уважение " + respect);
    }

    public void rob(Karavan karavan) {
        if (Math.random() < 0.75) {
            this.gold = this.gold + karavan.gold;
            this.respect = this.respect - karavan.lvl;
            exp = this.exp + karavan.lvl;
            karavan.robFailed=false;
        } else {
            respect = respect - karavan.lvl * 2;
            activity.println("Не удалось ограбить корован ");
            karavan.robFailed=true;
        }
    }

    public void lvlup() {
        if (exp >= expForNextLvlUp) {
            lvl = lvl + 1;
            expForNextLvlUp = expForNextLvlUp * 2;
        }
    }
}
