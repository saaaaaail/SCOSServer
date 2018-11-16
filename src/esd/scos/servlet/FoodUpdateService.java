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
		coldFoodList.add(new Food("�����ؼ�",10, store, REMARK,0, false, 0));
		coldFoodList.add(new Food("��θ�ݲ�",12, store,REMARK ,0,false,0));
		coldFoodList.add(new Food("���躣��˿",10, store,REMARK,0, false,0));
		coldFoodList.add(new Food("����ƹ�",10, store,REMARK,0, false,0));
		coldFoodList.add(new Food("±ţ��",30, store,REMARK,0, false,0));
		coldFoodList.add(new Food("�����Ұ�����",20, store,REMARK,0, false,0));
		coldFoodList.add(new Food("��֭����",15, store,REMARK,0, false,0));
		coldFoodList.add(new Food("�ཷ���˿",10, store,REMARK,0, false,0));
		//hot 1
		hotFoodList.add(new Food("���Զ���",20, store,REMARK,1, false,0));
		hotFoodList.add(new Food("��������",30, store,REMARK,1, false,0));
		hotFoodList.add(new Food("��������",20, store,REMARK,1, false,0));
		hotFoodList.add(new Food("������",45, store,REMARK,1, false,0));
		hotFoodList.add(new Food("������",40, store,REMARK,1, false,0));
		hotFoodList.add(new Food("���ּ���",30, store,REMARK,1,false,0));
	    hotFoodList.add(new Food("���Ŷ���",25, store,REMARK,1, false,0));
	    hotFoodList.add(new Food("������",40, store,REMARK,1, false,0));
	    hotFoodList.add(new Food("��Ȼ����",50, store,REMARK,1, false,0));
	    //sea 2
	    seaFoodList.add(new Food("��Ϻ����",50, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("���ݳ��²�",40, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("������",40, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("�ڹ����㼦����",55, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("����С��Ϻ",50, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("ơ�ƺ���",40, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("�峴Ϻ��",44, store,REMARK,2, false,0));
	    seaFoodList.add(new Food("��������з",60, store,REMARK,2,false,0));
	    seaFoodList.add(new Food("ˮз������",60, store,REMARK, 2,false,0));
	    //drink 3
	    drinkingList.add(new Food("������",20, store,REMARK,3, false,0));
	    drinkingList.add(new Food("��ݮ�㽶����",18, store,REMARK,3, false,0));
	    drinkingList.add(new Food("���",10, store,REMARK,3, false,0));
	    drinkingList.add(new Food("�������ɽҩ��",15, store,REMARK,3,false,0));
	    drinkingList.add(new Food("õ������¶",22, store,REMARK,3, false,0));
	    
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
             System.out.println("����XML������ʱ�䣺" + (endTime - startTime) + "ms");
			
             
			out = resp.getWriter();
			out.println(strxml);
		}else {
			
		  
		    JSONArray jsonArray =new JSONArray();
		    JSONArray foods = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			JSONObject fooditem = new JSONObject();
			
			 long startTime = System.currentTimeMillis();
			 
				jsonObject.put("���²�Ʒ����",newFoods.size());
				
				Set<String> keys = newFoods.keySet();
			//	List<Food>
				Iterator<String>iterator = keys.iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					fooditem.put("��Ʒ����",newFoods.get(key).getFoodName());
					fooditem.put("��Ʒ�۸�",newFoods.get(key).getPrice());
					fooditem.put("��Ʒ����",newFoods.get(key).getCategory());
					foods.add(fooditem);
				}
				jsonObject.put("��Ʒ�б�", foods);
				
             long endTime = System.currentTimeMillis();
             System.out.println("����JSON������ʱ�䣺" + (endTime - startTime) + "ms");
		
			
			
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
