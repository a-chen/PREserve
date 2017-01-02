package com.revature.middle;

import com.revature.beans.ReservationTable;
import com.revature.data.DataFacade;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service(value = "businessDelegate")
public class Delegate {

    private DataFacade facade;

    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    public HashSet<ReservationTable> getAllTables(){
        return facade.getAllTables();
    }
}
