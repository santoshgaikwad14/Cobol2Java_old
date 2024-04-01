package main;

import main.dto.*;

public class PartSuppAddrParser {

    public static PartSuppAddrPO parse(String dataLine) {

        //PartSuppAddrPO partSuppAddrPO = new PartSuppAddrPO();
        Parts parts = new Parts(dataLine);
        Suppliers suppliers = new Suppliers(dataLine);

        SuppAdd suppAdd1 = new SuppAdd(dataLine,1);
        SuppAdd suppAdd2 = new SuppAdd(dataLine, 2);
        SuppAdd suppAdd3 = new SuppAdd(dataLine, 3);

        PurchageOrder purchageOrder1 = new PurchageOrder(dataLine,1);
        PurchageOrder purchageOrder2 = new PurchageOrder(dataLine,2);
        PurchageOrder purchageOrder3 = new PurchageOrder(dataLine,3);

       // Parts parts, Suppliers suppliers, List< SuppAdd > suppAddLists, List< PurchageOrder > purchageOrderList

        PartSuppAddrPO partSuppAddrPO = new PartSuppAddrPO();
        partSuppAddrPO.setParts(parts);
        partSuppAddrPO.setSuppliers(suppliers);
        partSuppAddrPO.addSuppAddLists(suppAdd1);
        partSuppAddrPO.addSuppAddLists(suppAdd2);
        partSuppAddrPO.addSuppAddLists(suppAdd3);
        partSuppAddrPO.addPurchageOrderList(purchageOrder1);
        partSuppAddrPO.addPurchageOrderList(purchageOrder2);
        partSuppAddrPO.addPurchageOrderList(purchageOrder3);

        return partSuppAddrPO;

    }
}
