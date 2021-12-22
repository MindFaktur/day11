package acmUtility;

import acmUserInputs.UserInputs;

import java.util.Scanner;

public class utility {

    private Scanner SC = new Scanner(System.in);
    private UserInputs UI = new UserInputs();

    public Scanner getSC() {
        return SC;
    }

    public UserInputs getUI() {
        return UI;
    }
}
