package acmController;

import acmService.ServiceProvider.InterfaceMethods;

public class Controller {

    InterfaceMethods obj = new InterfaceMethods();

    public void menu() {
        int option = 0;
        while ( option != 3 ){
            option = menuChoice();

            switch (option){
                case 1:
                    InterfaceMethods.UT.getSC().nextLine();
                    obj.execution();
                    break;
                case 2:
                    System.out.println(InterfaceMethods.UT.getUI().getStockData());
                    break;
                default:
                    System.out.println("Please enter from above");
            }
        }
    }

    private int menuChoice() {
        System.out.println("Press " +
                "\n 1) Add Stock " +
                "\n 2) Print Stock Values " +
                "\n 3) quit ");
        return InterfaceMethods.UT.getSC().nextInt();
    }

}
