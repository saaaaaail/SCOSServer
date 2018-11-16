package esd.scos.servlet;

import java.util.List;
import esd.scos.servlet.FoodItem;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by sail on 2018/11/4.
 */



public class UpdateFood {

  
    private int updateCounts;


    private List<FoodItem> foodItemList;


	public int getUpdateCounts() {
		return updateCounts;
	}


	public void setUpdateCounts(int updateCounts) {
		this.updateCounts = updateCounts;
	}


	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}


	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}


}
