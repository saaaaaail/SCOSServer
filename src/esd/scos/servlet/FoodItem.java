package esd.scos.servlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by sail on 2018/11/5.
 */


public class FoodItem {


    private String foodName;


    private int price;

  
    private int category;

    public FoodItem() {}
    
    public FoodItem(String foodName,int price,int category) {
    	this.foodName = foodName;
    	this.price = price;
    	this.category = category;
    }
    
	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}
    
    
}
