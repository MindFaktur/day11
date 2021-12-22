package acmService.ServiceProvider;

import acmService.service;
import acmUserInputs.UserInputs;
import acmUtility.utility;
import sun.text.normalizer.Utility;

public class InterfaceMethods implements service {

    public static utility UT = new utility() ;

    @Override
    public void totalStockValue() {
        float val = UT.getUI().getNumberOfShares() * UT.getUI().getSharePrice();
        UT.getUI().setTotalStockValue(val);
    }

    @Override
    public void execution(){

        System.out.println("Please Enter Stock Name");
        UT.getUI().setStockName(UT.getSC().nextLine());

        System.out.println("Please Enter Price per Share");
        UT.getUI().setSharePrice(UT.getSC().nextFloat());

        System.out.println("Please Enter Number of Shares");
        UT.getUI().setNumberOfShares(UT.getSC().nextFloat());

        totalStockValue();

        UT.getUI().setSingleStockData("Share Price",UT.getUI().getSharePrice());
        UT.getUI().setSingleStockData("Number of Shares",UT.getUI().getNumberOfShares());
        UT.getUI().setSingleStockData("Total Stock Value",UT.getUI().getTotalStockValue());

        UT.getUI().setStockData(UT.getUI().getStockName(),UT.getUI().getSingleStockData());

    }
}
