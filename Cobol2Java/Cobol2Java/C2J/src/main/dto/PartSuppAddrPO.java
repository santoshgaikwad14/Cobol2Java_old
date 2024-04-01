package main.dto;

import java.util.ArrayList;
import java.util.List;

public class PartSuppAddrPO {

    private Parts parts;
    private Suppliers suppliers;

    private List<SuppAdd> suppAddLists = new ArrayList<>();

    private  List<PurchageOrder> purchageOrderList = new ArrayList<>() ;

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public List<SuppAdd> getSuppAddLists() {
        return suppAddLists;
    }

    public void addSuppAddLists(SuppAdd suppAddLists) {
        this.suppAddLists.add(suppAddLists);
    }

    public List<PurchageOrder> getPurchageOrderList() {
        return purchageOrderList;
    }

    public void addPurchageOrderList(PurchageOrder purchageOrder) {
        this.purchageOrderList.add(purchageOrder);
    }
}
