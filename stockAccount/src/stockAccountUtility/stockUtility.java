package stockAccountUtility;

import stockAccountCompany.UserInput;

import java.util.Scanner;

public class stockUtility {

    private final Scanner SC = new Scanner(System.in);
    private final UserInput UI = new UserInput();

    public UserInput getUI() {
        return UI;
    }

    public Scanner getSC() {
        return SC;
    }

}

//Close