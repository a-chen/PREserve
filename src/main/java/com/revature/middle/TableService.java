package com.revature.middle;

import com.revature.beans.ReservationTable;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TableService {

    private DataFacade facade;
    @Autowired
    void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    HashSet<ReservationTable> getAllTables(){
        return facade.getAllTables();
    }

    ReservationTable getTableById(int id) {
        return facade.getTableById(id);
    }

}
