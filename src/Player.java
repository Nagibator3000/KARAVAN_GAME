public class Player {
    int lvl;
    int exp;
    String name;
    public int gold;
    public int respect;
    public void printInfo() {
        System.out.println(name);
        System.out.println(exp+" exp");
        System.out.println("Ваше богатсво " + gold + " уважение " + respect);
    }

    public void rob(Karavan karavan) {
        this.gold = this.gold + karavan.gold;
        this.respect = this.respect - karavan.lvl;
        exp=this.exp+karavan.lvl;
    }

    public void sum(int a, int b) {
        int sum=a+b;
        System.out.println("summa ravna "+sum);

    }
}

