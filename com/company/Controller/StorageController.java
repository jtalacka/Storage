package com.company.Controller;

import com.company.Models.CSVReader;
import com.company.Models.Item;
import com.company.Models.Items;
import com.company.View.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StorageController {
    Menu menu;
    Items items;
    public StorageController(Menu menu, Items items){
        this.menu=menu;
        this.items=items;
    }
    public void start(){
        menu.mainScreen();
        CSVReader csvReader=new CSVReader("C:/Storage/out/production/Storage/com/company/sample.csv"); // reikia pasikeisti failo lokaciją
        csvReader.populateItems(items);
        items.sortList();
        items.mergeDuplicatesWhenSorted();
        action();
    }
        public void action(){
        int state=menu.getState();
        String data;
        while(state!=3){
            data=menu.inputLoop();
            state=menu.getState();
        if(state==1)
        {

            try {
                int quantity = Integer.parseInt(data);
                itemsWithCorrectQuantity(quantity);
            }catch(NumberFormatException e){
                menu.error();
                menu.setState(0);
            }
        }else if(state==2)
        {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
                itemsWithCorrectDate(date);
            }catch(NumberFormatException | ParseException e){
                menu.error();
                menu.setState(0);
            }

        }else if(state==0){
            menu.mainScreen();
        }}
    }
    public void itemsWithCorrectQuantity(int quantity){
        List<Item> data=items.getItemListLowerThanQuantity(quantity);
        menu.displayHeader(items.getParameterList());
        for(Item i:data){
            menu.displayItem(i);
        }
        menu.setState(0);
    }
    public void itemsWithCorrectDate(Date date){
        List<Item> data=items.getItemsHigherThanExpiration(date);
        menu.displayHeader(items.getParameterList());
        for(Item i:data){
            menu.displayItem(i);
        }
        menu.setState(0);
    }

}
