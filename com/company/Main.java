package com.company;

import com.company.Controller.StorageController;
import com.company.Models.Items;
import com.company.View.Menu;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Menu menu=new Menu();
        Items items=new Items();
        StorageController storageController=new StorageController(menu,items);
        storageController.start();
    }
}
