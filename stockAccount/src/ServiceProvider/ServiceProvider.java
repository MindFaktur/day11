package ServiceProvider;

import stockAccountUtility.stockUtility;

import java.util.HashMap;

public class ServiceProvider implements Service {

    public static stockUtility stockobj = new stockUtility();

    @Override
    public void addStocks(){

        System.out.println("Please enter stock name");
        String stockName = stockobj.getSC().nextLine();

        System.out.println("Please enter number of shares");
        Double sharesForTrading = stockobj.getSC().nextDouble();

        System.out.println("Please enter share price");
        Double sharePrice = stockobj.getSC().nextDouble();

        stockobj.getSC().nextLine();

        HashMap<String,Double> temp = new HashMap<>();
        temp.put("SharesForTrading",sharesForTrading);
        temp.put("SharePrice",sharePrice);

        stockobj.getUI().addStockstoExchangeData(stockName,temp);

        System.out.println(stockobj.getUI().getStocksInExchangeData());
        System.out.println(stockobj.getUI().getExchangeData());

    }

    @Override
    public void addUsers(){

        System.out.println("Please enter user name");
        String userName = stockobj.getSC().nextLine();

        System.out.println("Please enter your balance");
        Double balance = stockobj.getSC().nextDouble();

        stockobj.getSC().nextLine();

        stockobj.getUI().addUserDetails(userName,balance);

        System.out.println(stockobj.getUI().getAllUserDetails());

    }

    @Override
    public Boolean isUserExistInUserPortfolio(String user_name){
        boolean userExist = false;
        for ( String name : stockobj.getUI().getAllUserNames() ) {
            if( name.equals(user_name) ){
                userExist = true;
                break;
            }
        }
        if( userExist ){
            return userExist;
        }else{
            System.out.println("Username doesnt exist in our database");
            return userExist;
        }
    }

    @Override
    public Boolean isStockExistInUserPortfolio(String user_name, String stock_name){
        boolean stockExist = false;
        for ( String stock : stockobj.getUI().getUserBoughtStocks(user_name) ) {
            if( stock.equals(stock_name) ){
                stockExist = true;
                break;
            }
        }
        if( stockExist ){
            return stockExist;
        }else{
            System.out.println("This stock doesnt exist in user holdings");
            return stockExist;
        }
    }

    @Override
    public Boolean isStockExistInExchange(String stock_name){
        boolean stockExist = false;
        for ( String stock : stockobj.getUI().getStocksInExchangeData() ) {
            if( stock.equals(stock_name) ){
                stockExist = true;
                break;
            }
        }
        if( stockExist ){
            return stockExist;
        }else{
            System.out.println("This stock doesnt exist in exchange holdings");
            return stockExist;
        }
    }

    @Override
    public Boolean canUserBuyStock(String user_name, String stock_name, Double shares_to_buy){

        Double sharesForTrading = stockobj.getUI().getStockFieldData(stock_name,"SharesForTrading");
        Double sharePrice = stockobj.getUI().getStockFieldData(stock_name,"SharePrice");
        Double userBalance = stockobj.getUI().getUserBalance(user_name);

        boolean canBuy = false;

        if ( isStockExistInExchange(stock_name) ){
            if( shares_to_buy > sharesForTrading ){
                System.out.println("Number of shares you want to buy is greater than shares available for trading");
                canBuy = false;
                return canBuy;
            }else if ( ( sharePrice * shares_to_buy ) > userBalance ){
                System.out.println("Amount required to buy the number of shares is less");
                canBuy = false;
            }else if ( ( shares_to_buy < sharesForTrading ) && ( ( sharePrice * shares_to_buy ) < userBalance ) ){
                canBuy = true;
            }
        }
        return canBuy;
    }

    @Override
    public Boolean canUserSell(String user_name, String stock_name, Double shares_to_sell){

        Double stockHoldings = stockobj.getUI().getFieldDetailsOfStockBought(user_name,stock_name,"SharesBought");

        boolean canSell = false;

        if ( isStockExistInExchange(stock_name) && ( isStockExistInUserPortfolio(user_name,stock_name) ) ){
            if( shares_to_sell > stockHoldings ){
                System.out.println("Number of shares you want to sell is greater than shares you hold");
            }else {
                canSell = true;
            }
        }
        return canSell;

    }

    @Override
    public void buyStock(){

        System.out.println("Please enter your user name");
        String userName = stockobj.getSC().nextLine();

        System.out.println("Please enter the stock to buy");
        String stockToBuy = stockobj.getSC().nextLine();

        System.out.println("Please enter the number of shares to buy");
        Double numSharesToBuy = stockobj.getSC().nextDouble();

        stockobj.getSC().nextLine();

        if ( canUserBuyStock(userName,stockToBuy,numSharesToBuy) ){

            Double sharesForTrading = stockobj.getUI().getStockFieldData(stockToBuy,"SharesForTrading");
            Double sharePrice = stockobj.getUI().getStockFieldData(stockToBuy,"SharePrice");
            Double userBalance = stockobj.getUI().getUserBalance(userName);

            HashMap<String,Double> stockFieldData = new HashMap<>();


            stockFieldData.put("SharesBought",numSharesToBuy);
            stockFieldData.put("BoughtPrice",sharePrice);
            stockFieldData.put("TotalStockValue",( sharePrice * numSharesToBuy ));

            stockobj.getUI().setAllStocksSingleUserBought(stockToBuy,stockFieldData);
            stockobj.getUI().addSingleUserPortfolio(userName,stockobj.getUI().getAllStocksSingleUserBought());

           /* HashMap<String,HashMap<String,Double>> temp;
            temp = stockobj.getUI().getUserStockHoldings(userName);
            temp.put(stockToBuy,stockFieldData);
            */

            //stockobj.getUI().addSingleUserPortfolio(userName,temp);

            Double newUserBalance = userBalance - (sharePrice * numSharesToBuy);
            stockobj.getUI().updateUserBalance(userName,newUserBalance);

            Double updatedSharesForTrading = sharesForTrading - numSharesToBuy;
            stockobj.getUI().setStockFieldData(stockToBuy,"SharesForTrading",updatedSharesForTrading);

            System.out.println(stockobj.getUI().getExchangeData());
            System.out.println(stockobj.getUI().getAllUserPortfolio());

        }
    }

    @Override
    public void sellStock(){

        System.out.println("Please enter your user name");
        String userName = stockobj.getSC().nextLine();

        System.out.println("Please enter the stock to sell");
        String stockToSell = stockobj.getSC().nextLine();

        System.out.println("Please enter the number of shares to sell");
        Double numSharesToSell = stockobj.getSC().nextDouble();

        stockobj.getSC().nextLine();

        if ( canUserSell(userName,stockToSell,numSharesToSell) ){

            Double sharesForTrading = stockobj.getUI().getFieldDetailsOfStockBought(userName,stockToSell,"SharesBought");
            Double sharesInExchange = stockobj.getUI().getStockFieldData(stockToSell,"SharesForTrading");
            Double sharePrice = stockobj.getUI().getStockFieldData(stockToSell,"SharePrice");
            Double userBalance = stockobj.getUI().getUserBalance(userName);

            Double updatedUserShareBalance = sharesForTrading - numSharesToSell;
            stockobj.getUI().updateUserBoughtStockFieldValue(userName,stockToSell,"SharesBought",updatedUserShareBalance);

            Double totalStockValue = stockobj.getUI().getFieldDetailsOfStockBought(userName,stockToSell,"TotalStockValue");
            Double updatedStockValue = totalStockValue - (stockobj.getUI().getFieldDetailsOfStockBought(userName,stockToSell,"SharesBought") * sharePrice );
            stockobj.getUI().updateUserBoughtStockFieldValue(userName,stockToSell,"TotalStockValue",updatedStockValue);

            stockobj.getUI().setStockFieldData(stockToSell,"SharesForTrading",(numSharesToSell + sharesInExchange));

            Double newUserBalance = userBalance + (sharePrice * numSharesToSell);
            stockobj.getUI().updateUserBalance(userName,newUserBalance);

            Double updatedSharesForTrading = sharesForTrading + numSharesToSell;
            stockobj.getUI().setStockFieldData(stockToSell,"SharesForTrading",updatedSharesForTrading);

            System.out.println(stockobj.getUI().getExchangeData());
            System.out.println(stockobj.getUI().getAllUserPortfolio());

        }
    }
    @Override
    public void printExchangeData(){
        System.out.println(stockobj.getUI().getExchangeData());
    }

    @Override
    public void printUserPortfoilio(){
        System.out.println(stockobj.getUI().getAllUserPortfolio());
    }

}


//Close