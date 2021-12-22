package acmUserInputs;

import java.util.HashMap;

public class UserInputs {

    private String stockName;
    private Float sharePrice, numberOfShares, totalStockValue;

    private HashMap<String,Float> singleStockData = new HashMap<>();
    private HashMap<String,HashMap<String,Float>> stockData = new HashMap<>();

    public Float getTotalStockValue() {
        return totalStockValue;
    }

    public void setTotalStockValue(Float totalStockValue) {
        this.totalStockValue = totalStockValue;
    }

    public HashMap<String, Float> getSingleStockData() {
        return singleStockData;
    }

    public void setSingleStockData(String share_price, Float value) {
        singleStockData.put(share_price, value);
    }

    public HashMap<String, HashMap<String, Float>> getStockData() {
        return stockData;
    }

    public void setStockData(String name, HashMap<String, Float> val ) {
        stockData.put(name,val);
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Float getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Float sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Float getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Float numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

}
