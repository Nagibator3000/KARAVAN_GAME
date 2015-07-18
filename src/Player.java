public class Player {
    int lvl;
    int exp;
    int expForNextLvlUp;
    String name;
    public int gold;
    public int respect;
    public void printInfo() {
        System.out.println(name);
        System.out.println(exp+" exp "+lvl+" уровень");
        System.out.println("Ваше богатсво " + gold + " уважение " + respect);
    }

    public void rob(Karavan karavan) {
        this.gold = this.gold + karavan.gold;
        this.respect = this.respect - karavan.lvl;
        exp=this.exp+karavan.lvl;
    }
    public void lvlup(){
    if (exp>=expForNextLvlUp) {
        lvl=lvl+1;
        expForNextLvlUp=expForNextLvlUp*2;
    }
    }
}

