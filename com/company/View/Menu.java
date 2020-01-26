package com.company.View;

import com.company.Models.Item;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private int state=0;
    public Menu(){

    }
    public void mainScreen(){
        state=0;
        clearScreen();
        System.out.println("-------------");
        System.out.println("1.Check Quantity");
        System.out.println("2.Expiration date");
        System.out.println("3.Quit");
    }
    public String inputLoop(){
        Scanner sc = new Scanner(System.in);
        char c='0';
        while(c!='3'){
        c = sc.next().charAt(0);
        if(c=='1'){
            setState(Character.getNumericValue(c));
            return stringInput();
        }else if(c=='2'){
            setState(Character.getNumericValue(c));
            return stringInput();
        }
    }
        setState(Character.getNumericValue(c));
        return "";
    }
    public void quantityScreen(){
        state=1;
        clearScreen();
        System.out.println("Please enter a Quantity  (Only numbers are allowed)");

    }
    public void expirationScreen(){
        state=2;
        clearScreen();
        System.out.println("Please enter a Expiration date (Use the format yyyy-mm-dd example 2019-01-26)");
    }
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void error(){
        System.out.println("Incorrect format was entered");
    }

    public int getState() {
        return state;
    }
    public void setState(int state){
        this.state=state;
        if(state==0){
            mainScreen();
        }else if(state==1){
            quantityScreen();
        }else if(state==2) {
            expirationScreen();
        }
    }

    public void displayHeader(List<String> header){
        for(String h:header){
            System.out.print(h+" ");
        }
        System.out.print("\n");
    }
    public void displayItem(Item item){
        System.out.println(item.getName()+" "+item.getCode()+" "+item.getQuantity()+" "+new SimpleDateFormat("yyyy-MM-dd").format(item.getExpiration()));
    }
}
