package lv.gb.unittest;

import lv.gb.unittest.hwt.view.ConsoleUI;
import lv.gb.unittest.hwt.view.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();

    }
}