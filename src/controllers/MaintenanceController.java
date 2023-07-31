package controllers;
import model.Maintenance;
import view.*;

import javax.swing.*;

public class MaintenanceController {

    Maintenance modelMaintenance;
    MaintenanceFrame maintenanceFrame;
    RestockItemFrame restockItemFrame;
    SetPriceFrame setPriceFrame;
    MoneyMaintenanceFrame moneyMaintenanceFrame;
    SummaryFrame summaryFrame;
    public MaintenanceController(MaintenanceFrame maintenanceFrame){

        this.modelMaintenance = new Maintenance();
        this.maintenanceFrame = maintenanceFrame;
    }

    public boolean pushedStockItemBtn(){
        maintenanceFrame.setFrame(false);
        this.restockItemFrame = new RestockItemFrame(maintenanceFrame,this);
        restockItemFrame.setVisible(true);

        return true;
    }

    public boolean pushedPriceBtn(){
        maintenanceFrame.setFrame(false);
        this.setPriceFrame = new SetPriceFrame(maintenanceFrame,this);
        setPriceFrame.setVisible(true);

        return true;
    }


    public boolean pushedMoneyStockBtn(){
        maintenanceFrame.setFrame(false);
        this.moneyMaintenanceFrame = new MoneyMaintenanceFrame(maintenanceFrame,this);
        moneyMaintenanceFrame.setVisible(true);

        return true;
    }

    /*
    public boolean pushedSummaryBtn(){
        maintenanceFrame.setFrame(false);
        this.summaryFrame = new SummaryFrame(maintenanceFrame,this);
        summaryFrame.setVisible(true);

        return true;
    }*/

    public boolean pushedDone(JFrame frame, String frameName){
        frame.dispose();
        if (frameName.equals("setPriceFrame"))
            setPriceFrame.getFrame().dispose();
        if (frameName.equals("moneyMaintenanceFrame"))
            moneyMaintenanceFrame.getFrame().dispose();
        if (frameName.equals("restockItemFrame"))
            restockItemFrame.getFrame().dispose();
        this.maintenanceFrame.setFrame(true);

        return true;
    }
}
