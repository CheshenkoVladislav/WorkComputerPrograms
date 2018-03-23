package com.example.vladislav.recycleapplication.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by vladislav on 15.03.18.
 */

public class Item implements Serializable {
    private int id;

    private String name;

    private int price;

    private String type;

    private Date date;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
}
