package stockAccountCompany;

import java.util.HashMap;
import java.util.Set;

public class UserInput {

    // Stock data at exchange
    private final HashMap<String,HashMap<String,Double>> exchangeData = new HashMap<>();

    public Set<String> getStocksInExchangeData(){
        return exchangeData.keySet();
    }
    public HashMap<String,HashMap<String,Double>> getExchangeData(){
        return exchangeData;
    }
    public void addStockstoExchangeData(String stock_name,HashMap<String,Double> val){
        exchangeData.put(stock_name,val);
    }
    public Double getStockFieldData(String stock_name, String field_name){
        return exchangeData.get(stock_name).get(field_name);
    }
    public void setStockFieldData(String stock_name, String field_name, Double val){
        exchangeData.get(stock_name).put(field_name,val);
    }


    // User's details
    private final HashMap<String,Double> userDataBase = new HashMap<>();

    public void addUserDetails(String user_name,Double balance){
        userDataBase.put(user_name,balance);
    }
    public HashMap<String,Double> getAllUserDetails(){
        return userDataBase;
    }
    public Set<String> getAllUserNames(){
        return userDataBase.keySet();
    }
    public void updateUserBalance(String user_name,Double balance){
        userDataBase.put(user_name,balance);
    }
    public Double getUserBalance(String user_name){
        return userDataBase.get(user_name);
    }


    // User Portfolio methods
    private final static HashMap<String,HashMap<String,HashMap<String,Double>>> userPortfolio = new HashMap<>();

    public void addSingleUserPortfolio(String user_name,HashMap<String,HashMap<String,Double>> val){
        userPortfolio.put(user_name,val);
    }
    public HashMap<String,HashMap<String,Double>> getSingleUserStocks(String stock_name,HashMap<String,Double> val){
        HashMap<String,HashMap<String,Double>> temp = new HashMap<>();
        temp.put(stock_name,val);
        return temp;
    }
    public Set<String> getUserNames(String user_name,HashMap<String,HashMap<String,Double>> val){
        return userPortfolio.keySet();
    }
    public Set<String> getUserBoughtStocks(String user_name){
        HashMap<String,HashMap<String,Double>> temp = userPortfolio.get(user_name);
        return temp.keySet();
    }
    public HashMap<String,HashMap<String,HashMap<String,Double>>> getAllUserPortfolio(){
        return userPortfolio;
    }

    public void updateUserBoughtStockFieldValue(String user_name,String stock_name, String field_name, Double val){
        userPortfolio.get(user_name).get(stock_name).put(field_name,val);
    }
    public Double getFieldDetailsOfStockBought(String user_name, String stock_name, String field_name){
        return userPortfolio.get(user_name).get(stock_name).get(field_name);
    }

    private final HashMap<String,HashMap<String,Double>> userStockData = new HashMap<>();
    public void setAllStocksSingleUserBought(String stock_name,HashMap<String,Double> val){
        userStockData.put(stock_name,val);
    }
    public HashMap<String,HashMap<String,Double>> getAllStocksSingleUserBought(){
        return userStockData;
    }




}