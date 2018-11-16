package esd.scos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FoodUpdateService extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		String format = req.getParameter("format");
		PrintWriter out = resp.getWriter();
		int store = 1;
		String REMARK = "good!!";
		List<Food> coldFoodList = new ArrayList<Food>();
		List<Food> hotFoodList = new ArrayList<Food>();
		List<Food> seaFoodList = new ArrayList<Food>();
		List<Food> drinkingList = new ArrayList<Food>();
		//cold 0
		coldFoodList.add(new Food("椒油素鸡",10, store, REMARK,0, false, 0));
		coldFoodList.add(new Food("开胃泡菜",12, store,REMARK ,0,false,0));
		coldFoodList.add(new Food("凉拌海带丝",10, store,REMARK,0, false,0));
		coldFoodList.add(new Food("凉拌黄瓜",10, store,REMARK,0, false,0));
		coldFoodList.add(new Food("卤牛肉",30, store,REMARK,0, false,0));
		coldFoodList.add(new Food("东北家拌凉菜",20, store,REMARK,0, false,0));
		coldFoodList.add(new Food("浇汁豆腐",15, store,REMARK,0, false,0));
		coldFoodList.add(new Food("青椒拌干丝",10, store,REMARK,0, false,0));
		//hot 1
		hotFoodList.add(new Food("干煸豆角",20, store,REMARK,1, false,0));
		hotFoodList.add(new Food("宫保鸡丁",30, store,REMARK,1, false,0));
		hotFoodList.add(new Food("红烧茄子",20, store,REMARK,1, false,0));
		hotFoodList.add(new Food("红烧肉",45, store,REMARK,1, false,0));
		hotFoodList.add(new Food("红烧鱼",40, store,REMARK,1, false,0));
		hotFoodList.add(new Food("可乐鸡翅",30, store,REMARK,1,false,0));
	    hotFoodList.add(new Food("麻婆豆腐",25, store,REMARK,1, false,0));
	    hotFoodList.add(new Food("羊肉汤",40, store,REMARK,1, false,0));
	    hotFoodList.add(new Food("孜然羊肉",50, store,REMARK,1, false,0));
	    //sea 2
	    seaFoodList.add(new Food("大虾两吃",50, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("海螺炒韭菜",40, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("海鲜汤",40, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("节瓜章鱼鸡脚汤",55, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("麻辣小龙虾",50, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("啤酒海螺",40, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("清炒虾仁",44, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("清蒸梭子蟹",60, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("水蟹冬瓜汤",60, store,REMARK, 2,false,0));
	    //drink 3
	    drinkingList.add(new Food("百香多多",20, store,REMARK,3, false,0));
	    drinkingList.add(new Food("草莓香蕉奶昔",18, store,REMARK,3, false,0));
	    drinkingList.add(new Food("红茶",10, store,REMARK,3, false,0));
	    drinkingList.add(new Food("红枣核桃山药饮",15, store,REMARK,3,false,0));
	    drinkingList.add(new Food("玫瑰情人露",22, store,REMARK,3, false,0));
	    
	    Map<String,Food> newFoods = new HashMap<>();
	    
	    
	    int item = (int) (Math.random()*10);
	    while(item!=0) {
		    int cate = (int) (Math.random()*4);
		    
		    switch(cate) {
		    case 0:
		    	item = (int) (Math.random()*(coldFoodList.size()-1));
		    	if(!newFoods.containsKey(coldFoodList.get(item).getFoodName())) {
		    	 newFoods.put(coldFoodList.get(item).getFoodName(),coldFoodList.get(item));
		    	}
		    	break;
		    case 1:
		    	item = (int) (Math.random()*hotFoodList.size());
		    	if(!newFoods.containsKey(hotFoodList.get(item).getFoodName())) {
		    		newFoods.put(hotFoodList.get(item).getFoodName(),hotFoodList.get(item));
		    	}
		    	break;
		    case 2:
		    	item = (int) (Math.random()*seaFoodList.size());
		    	if(!newFoods.containsKey(seaFoodList.get(item).getFoodName())) {
		    		newFoods.put(seaFoodList.get(item).getFoodName(),seaFoodList.get(item));
		    	}
		    	break;
		    case 3:
		    	item = (int) (Math.random()*drinkingList.size());
		    	if(!newFoods.containsKey(drinkingList.get(item).getFoodName())) {
		    		newFoods.put(drinkingList.get(item).getFoodName(),drinkingList.get(item));
		    	}
		    	break;
		    }
	    }
	    /*
	    int num=0;
	    while(num<100000){
	    	//int item = (int) (Math.random()*(coldFoodList.size()-1));
	    	newFoods.put(num+"", coldFoodList.get(0));
	    	num++;
	    }
	    */
		if(format.equals("xml")) {
		
		    UpdateFood updateFood = new UpdateFood();
		    updateFood.setUpdateCounts(newFoods.size());
		    Set<String> keys = newFoods.keySet();
			Iterator<String>iterator = keys.iterator();
			List<FoodItem> foodItems = new ArrayList<>();
			while(iterator.hasNext()) {
				String key = iterator.next();
				FoodItem fooditem = new FoodItem(
						newFoods.get(key).getFoodName()
						, newFoods.get(key).getPrice()
						, newFoods.get(key).getCategory());
				foodItems.add(fooditem);
			}
			updateFood.setFoodItemList(foodItems);
			
			
			
			 long startTime = System.currentTimeMillis();
			 String strxml = XMLUtil.ToXml(updateFood);
             long endTime = System.currentTimeMillis();
             System.out.println("生成XML的运行时间：" + (endTime - startTime) + "ms");
			
             
			out = resp.getWriter();
			out.println(strxml);
		}else {
			
		  
		    JSONArray jsonArray =new JSONArray();
		    JSONArray foods = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			JSONObject fooditem = new JSONObject();
			
			 long startTime = System.currentTimeMillis();
			 
				jsonObject.put("更新菜品数量",newFoods.size());
				
				Set<String> keys = newFoods.keySet();
			//	List<Food>
				Iterator<String>iterator = keys.iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					fooditem.put("菜品名称",newFoods.get(key).getFoodName());
					fooditem.put("菜品价格",newFoods.get(key).getPrice());
					fooditem.put("菜品类型",newFoods.get(key).getCategory());
					foods.add(fooditem);
				}
				jsonObject.put("菜品列表", foods);
				
             long endTime = System.currentTimeMillis();
             System.out.println("生成JSON的运行时间：" + (endTime - startTime) + "ms");
		
			
			
			//jsonArray.add(jsonObject);
			out = resp.getWriter();
			out.println(jsonObject);
			//out.write(jsonArray.toString());
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
