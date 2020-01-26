package com.company.Models;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Items {
    public Items() {
        clearData();
    }

    private List<Item> itemList;
    private List<String> parameterName;

    public Item getItemFromList(int index) {
        if(index>=itemList.size()){
            return null;
        }else {
        return itemList.get(index);
    }}
    public void clearData(){
        itemList=new LinkedList<>();
        parameterName=new LinkedList<>();
    }
    public void addToItemList(Item item){
        itemList.add(item);
    }
    public void sortList(){
        Collections.sort(itemList);
    }
    public void mergeDuplicatesWhenSorted(){
        for(int index1=0;index1<itemList.size()-1;index1++){
            for(int index2=index1+1;index2<itemList.size();index2++){
                if(itemList.get(index1).getName().equals(itemList.get(index2).getName())){
                    if(itemList.get(index1).getCode().equals(itemList.get(index2).getCode())&&itemList.get(index1).getExpiration().equals(itemList.get(index2).getExpiration())){
                        itemList.get(index1).setQuantity(itemList.get(index1).getQuantity()+itemList.get(index2).getQuantity());
                        itemList.remove(index2);
                        index2--;
                    }
                }else{
                    break;
                }
            }
        }

    }
    public String getParameterName(int index){
        if(index>=parameterName.size()){
            return null;
        }else{
        return parameterName.get(index);
    }}
    public List<Item> getItemListLowerThanQuantity(int quantity){
        List<Item> i=new LinkedList<Item>(itemList);
        for(int index=0;index<i.size();index++){
            if(i.get(index).getQuantity()>quantity){
                i.remove(index);
                index--;
            }
        }
        return i;
    }
    public List<Item> getItemsHigherThanExpiration(Date date){
        List<Item> i=new LinkedList<Item>(itemList);
        for(int index=0;index<i.size();index++){
            if(i.get(index).getExpiration().compareTo(date)<0){
                i.remove(index);
                index--;
            }
        }
        return i;
    }
    public List<String> getParameterList(){
        return new LinkedList<String>(parameterName);
    }
    public void addParameter(String parameter){
        parameterName.add(parameter);
    }
}
