package stockAccountController;

import ServiceProvider.Service;
import ServiceProvider.ServiceProvider;
import stockAccountCompany.UserInput;
import stockAccountUtility.stockUtility;

public class Controller {

    static stockUtility stockObj = new stockUtility();
    static ServiceProvider obj = new ServiceProvider();

    static void menu() {
        System.out.println(" Press " +
                "\n 1) Add stocks to exchange " +
                "\n 2) Add users to user name database " +
                "\n 3) Buy stocks " +
                "\n 4) Sell Stocks " +
                "\n 5) Print exchange stock data " +
                "\n 6) Print user portfoilio database " +
                "\n 7) Quit "
                );
    }

    public static void menuChoiceActions(){
        int option = 0;

        while ( option != 7 ){
            menu();
            option = stockObj.getSC().nextInt();
            stockObj.getSC().nextLine();

            switch (option){

                case 1:
                    obj.addStocks();
                    break;

                case 2:
                    obj.addUsers();
                    break;

                case 3:
                    obj.buyStock();
                    break;

                case 4:
                    obj.sellStock();
                    break;

                case 5:
                    obj.printExchangeData();
                    break;

                case 6:
                    obj.printUserPortfoilio();
                    break;

                case 7:
                    break;

                default:
                    System.out.println("please choose from above");

            }
        }
    }

}
