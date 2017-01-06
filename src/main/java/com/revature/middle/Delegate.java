package com.revature.middle;

import com.revature.beans.Item;
import com.revature.beans.OrderItem;
import com.revature.beans.Reservation;
import com.revature.beans.ReservationTable;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service(value = "businessDelegate")
public class Delegate {

    private DataFacade facade;

    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    public HashSet<ReservationTable> getAllTables(){
        return facade.getAllTables();
    }
    
    public HashSet<OrderItem> getAllorderItems(){
    	return facade.getAllorderItems();
    }
    
    public HashSet<OrderItem> getorderItemByOrderId(int id){
    	return facade.getorderItemByOrderId(id);
    }
    
    public HashSet<Item> getAllItems(){
    	return facade.getAllItems();
    }

    public Item getItemById(int id){
    	return facade.getItemById(id);
    }
    public void createReseveration(Reservation reservation){ return facade.createReservation(reservation);}
}
