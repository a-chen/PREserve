package com.revature.middle;

import com.revature.beans.Item;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ItemService {

    private DataFacade facade;
    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    HashSet<Item> getAllItems() {
        return facade.getAllItems();
    }

    Item getItemById(int id) {
        return facade.getItemById(id);
    }
}
