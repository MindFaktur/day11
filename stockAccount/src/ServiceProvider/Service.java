package ServiceProvider;

public interface Service {

    void addStocks();

    void addUsers();

    Boolean isUserExistInUserPortfolio(String user_name);

    Boolean isStockExistInUserPortfolio(String user_name, String stock_name);

    Boolean isStockExistInExchange(String stock_name);

    Boolean canUserBuyStock(String user_name, String stock_name, Double shares_to_buy);

    Boolean canUserSell(String user_name, String stock_name, Double shares_to_sell);

    void buyStock();

    void sellStock();

    void printExchangeData();

    void printUserPortfoilio();

}

//Close