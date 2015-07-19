package com.kirilgaming.kirill.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kirilgaming.kirill.Karavan;
import com.kirilgaming.kirill.Player;
import com.kirilgaming.kirill.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Bind(R.id.textview)
    TextView outputView;

    @Bind(R.id.button1)
    Button button1;

    @Bind(R.id.button2)
    Button button2;

    @Bind(R.id.button3)
    Button button3;

    @Bind(R.id.button4)
    Button button4;

    @Bind(R.id.button5)
    Button button5;

    @Bind(R.id.scrollView)
    ScrollView scrollView;

    private Karavan currentKaravan;
    private Player player;
    private ArrayList<Karavan> karavansList;
    private boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        init();
    }

    private void init() {

        cleanOutput();
        gameOver = false;
        karavansList = new ArrayList<>();
        player = new Player(this);    //TODO добавить в игрока коллекцию с солдатами, сделать класс Soldat с силой, именем и стоимостью найма в день
        player.expForNextLvlUp = 5;
        player.respect = 5;
        player.gold = 10;
        player.lvl = 1;
        player.exp = 0;
        println("Вас зовут?");
        player.name = "Kirill";
        player.printInfo();

        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button1.setText("OGRABIT");
        button2.setText("NE OGRABIT");

        createNewKaravan();
    }

    private void cleanOutput() {
        outputView.setText("");
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    private void createNewKaravan() {
        currentKaravan = new Karavan(this);
        currentKaravan.lvl = (int) (Math.random() * 5 + 1);
        currentKaravan.goldKaravan();
        currentKaravan.printInfo();
        println(" хотите его ограбить?");
    }

    @OnClick(R.id.button1)
    void onClick1() {
        if (gameOver) {
            init();
        } else {
            player.rob(currentKaravan);
            afterAction();
        }
    }

    @OnClick(R.id.button2)
    void onClick2() {
        player.respect = player.respect + currentKaravan.lvl;
        afterAction();
    }

    private void afterAction() {
        karavansList.add(currentKaravan);
        player.gold -= 3;
        player.lvlup();
        player.printInfo();
        if (player.respect < 0 || player.gold < 0) {
            gameOver();
        } else {
            println();
            createNewKaravan();
        }
    }

    private void gameOver() {
        println("___GAME OVER___");
        println("SPisok karavanov");
        for (Karavan karavan : karavansList) {
            karavan.printInfo();     //TODO выводить резуьтат боя
        }
        println();

        gameOver = true;

        button1.setText("Start again?");
        button2.setVisibility(View.GONE);
    }

    public void println(String s) {
        outputView.append( s + "\n");
        scrollBottom(); //TODO вызывать только когда нужно что бы сохранялась анимация
    }

    private void println() {
        outputView.append("\n");
        scrollBottom(); //TODO вызывать только когда нужно
    }

    private void scrollBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}
