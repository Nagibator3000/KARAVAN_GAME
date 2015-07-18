import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args) throws IOException

    {
        ArrayList<Karavan> karavansList= new ArrayList<>();
        Player player = new Player();
        player.expForNextLvlUp =5;
        player.respect = 5;
        player.gold = 10;
        player.lvl = 1;
        player.exp = 0;
        System.out.println("Вас зовут?");
        String newName = getInputString();
        player.name = newName;
        player.printInfo();
        while (true) {
            Karavan karavan = new Karavan();
            karavan.lvl = (int) (Math.random() * 5 + 1);
            karavan.goldKaravan();
            karavan.printInfo();
            System.out.println(" хотите его ограбить?");
            String userInput = getInputString();
            if (userInput.toUpperCase().equals("Y")) {

                player.rob(karavan);

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
        for (Karavan karavan:karavansList){
            karavan.printInfo();
        }

    }


    private static String getInputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
