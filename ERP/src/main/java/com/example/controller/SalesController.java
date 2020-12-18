package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.DayVO;
import com.example.mapper_oracle.SalesMapper;


@Controller
public class SalesController {
   
   @Autowired
   SalesMapper salesMapper;
   
      @RequestMapping("salesCategoryCount.json")
      @ResponseBody
      public List<HashMap<String, Object>> salesCategoryCountJson(HttpSession session) {
    	  String companyCode = "";
         
         return salesMapper.salesCategoryCount();
      }

      @RequestMapping("refundCategoryCount.json")
      @ResponseBody
      public List<HashMap<String, Object>> refundCategoryCountJson(HttpSession session){
         String companyCode = "";
    	  
         return salesMapper.refundCategoryCount();
      }
      
         @RequestMapping("salesList")
         public void salesList() {
         }
         
         @RequestMapping("salesPayTypeList.json")
         @ResponseBody
         public List<ArrayList<Object>> salesPayTypeListJson(HttpSession session, String date, String payType, String lCategory) {
        	 String companyCode = "347-88-00867";
        	 date = date.substring(2);
        	 
        	 List<HashMap<String, Object>> array = salesMapper.salesPayTypeList(date, companyCode, payType, lCategory);
        	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
             ArrayList<Object> arr = new ArrayList<>();
             arr.add("유형");
             arr.add("금액");
             listArr.add(arr);
             
             for(HashMap<String, Object> map:array) {
            	 arr = new ArrayList<>();
            	 arr.add(map.get("PAYTYPE"));
            	 arr.add(map.get("SALESAMOUNT"));
            	 listArr.add(arr);
             }
             return listArr;
         }
         
         @RequestMapping("refundPayTypeList.json")
         @ResponseBody
         public List<ArrayList<Object>> refundPayTypeListJson(HttpSession session, String date, String payType, String lCategory) {
        	 String companyCode = "347-88-00867";
        	 date = date.substring(2);
        	 
        	 List<HashMap<String, Object>> array = salesMapper.refundPayTypeList(date, companyCode, payType, lCategory);
        	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
             ArrayList<Object> arr = new ArrayList<>();
             arr.add("유형");
             arr.add("금액");
             listArr.add(arr);
             
             for(HashMap<String, Object> map:array) {
            	 arr = new ArrayList<>();
            	 arr.add(map.get("PAYTYPE"));
            	 arr.add(map.get("REFUNDAMOUNT"));
            	 listArr.add(arr);
             }
             return listArr;
         }
         
         @RequestMapping("salesMCategoryList.json")
         @ResponseBody
         public List<ArrayList<Object>> salesMCategoryListJson(HttpSession session, String date, String mCategory, String lCategory) {
        	 String companyCode = "347-88-00867";
        	 date = date.substring(2);
        	 
        	 List<HashMap<String, Object>> array = salesMapper.salesMCategoryList(date, companyCode, mCategory, lCategory);
        	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
             ArrayList<Object> arr = new ArrayList<>();
             arr.add("유형");
             arr.add("금액");
             listArr.add(arr);
             
             for(HashMap<String, Object> map:array) {
            	 arr = new ArrayList<>();
            	 arr.add(map.get("MCATEGORY"));
            	 arr.add(map.get("SALESAMOUNT"));
            	 listArr.add(arr);
             }
             return listArr;
         }
         
         @RequestMapping("refundMCategoryList.json")
         @ResponseBody
         public List<ArrayList<Object>> refundMCategoryListJson(HttpSession session, String date, String mCategory, String lCategory) {
        	 String companyCode = "347-88-00867";
        	 date = date.substring(2);
        	 
        	 List<HashMap<String, Object>> array = salesMapper.refundMCategoryList(date, companyCode, mCategory, lCategory);
        	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
             ArrayList<Object> arr = new ArrayList<>();
             arr.add("유형");
             arr.add("금액");
             listArr.add(arr);
             
             for(HashMap<String, Object> map:array) {
            	 arr = new ArrayList<>();
            	 arr.add(map.get("MCATEGORY"));
            	 arr.add(map.get("REFUNDAMOUNT"));
            	 listArr.add(arr);
             }
             return listArr;
         }
         
         @RequestMapping("salesSubTotalList.json")
         @ResponseBody
         public List<ArrayList<Object>> salesSubTotalListJson(HttpSession session, String date, String lCategory) {
        	String companyCode = "347-88-00867";
        	date = date.substring(2);
        	
        	List<HashMap<String, Object>> array = salesMapper.salesSubTotalList(date, companyCode, lCategory);
       	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
            ArrayList<Object> arr = new ArrayList<>();
            arr.add("분류");
            arr.add("금액");
            listArr.add(arr);
            
            for(HashMap<String, Object> map:array) {
           	 arr = new ArrayList<>();
           	 arr.add(map.get("LCATEGORY"));
           	 arr.add(map.get("SALESAMOUNT"));
           	 listArr.add(arr);
            }
            return listArr;
         }
         
         @RequestMapping("refundSubTotalList.json")
         @ResponseBody
         public List<ArrayList<Object>> refundSubTotalListJson(HttpSession session, String date, String lCategory) {
        	String companyCode = "347-88-00867";
        	date = date.substring(2);
        	
        	List<HashMap<String, Object>> array = salesMapper.refundSubTotalList(date, companyCode, lCategory);
       	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
            ArrayList<Object> arr = new ArrayList<>();
            arr.add("분류");
            arr.add("금액");
            listArr.add(arr);
            
            for(HashMap<String, Object> map:array) {
           	 arr = new ArrayList<>();
           	 arr.add(map.get("LCATEGORY"));
           	 arr.add(map.get("REFUNDAMOUNT"));
           	 listArr.add(arr);
            }
            return listArr;
         }
         
         @RequestMapping("salesTotalList.json")
         @ResponseBody
         public List<ArrayList<Object>> salesTotalListKson(HttpSession session, String date, String payType) {
        	 String companyCode = "347-88-00867";
         	date = date.substring(2);
        	 
         	List<HashMap<String, Object>> array = salesMapper.salesTotalList(date, companyCode, payType);
          	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
               ArrayList<Object> arr = new ArrayList<>();
               arr.add("분류");
               arr.add("금액");
               listArr.add(arr);
               
               for(HashMap<String, Object> map:array) {
              	 arr = new ArrayList<>();
              	 arr.add(map.get("PAYTYPE"));
              	 arr.add(map.get("SALESAMOUNT"));
              	 listArr.add(arr);
               }
               return listArr;
         }
         
         @RequestMapping("refundTotalList.json")
         @ResponseBody
         public List<ArrayList<Object>> refundTotalListKson(HttpSession session, String date, String payType) {
        	 String companyCode = "347-88-00867";
         	date = date.substring(2);
        	 
         	List<HashMap<String, Object>> array = salesMapper.refundTotalList(date, companyCode, payType);
          	 List<ArrayList<Object>> listArr = new ArrayList<>(); 
               ArrayList<Object> arr = new ArrayList<>();
               arr.add("분류");
               arr.add("금액");
               listArr.add(arr);
               
               for(HashMap<String, Object> map:array) {
              	 arr = new ArrayList<>();
              	 arr.add(map.get("PAYTYPE"));
              	 arr.add(map.get("REFUNDAMOUNT"));
              	 listArr.add(arr);
               }
               return listArr;
         }
         
         @RequestMapping("monthlyTotalAmount.json")
         @ResponseBody
         public int monthlyTotalAmountJson(String date) {
        	 String companyCode = "347-88-00867";
          	date = date.substring(2);
        	 int salesAmount = salesMapper.salesAmount(date, companyCode);
        	 int refundAmount = salesMapper.refundAmount(date, companyCode);
        	 int amount = 0;
        	 if(salesAmount >= refundAmount) {
        		 amount = salesAmount;
        	 }
        	 if(salesAmount <= refundAmount) {
        		 amount = refundAmount;
        	 }
        	 return amount;
         }
         
         @RequestMapping("SRdailyYearList.json")
     	@ResponseBody
     	public List<HashMap<String, Object>> dailyYearJson(HttpSession session) {
        	 String companyCode = "347-88-00867";
     		List<HashMap<String, Object>> array = salesMapper.SRdailyYearList(companyCode);
     		List<HashMap<String, Object>> listArr = new ArrayList<>();
     		for(int i = 0; i < array.size(); i++) {
     			HashMap<String, Object> y = new HashMap<>();
     			y.put("year", "20" + array.get(i).get("YEAR"));
     			listArr.add(y);
     		}
     		return listArr;
     	}
     	
     	@RequestMapping("SRdailyMonthList.json")
     	@ResponseBody
     	public List<HashMap<String, Object>> dailyMonthJson(HttpSession session, String year) {
     		year = year.substring(2);
     		String companyCode = "347-88-00867";
     		List<HashMap<String, Object>> array = salesMapper.SRdailyMonthList(year, companyCode);
     		List<HashMap<String, Object>> listArr = new ArrayList<>();
     		for(int i = 0; i < array.size(); i++) {
     			HashMap<String, Object> y = new HashMap<>();
     			y.put("month", array.get(i).get("MONTH"));
     			listArr.add(y);
     		}
     		return listArr;
     	}
     	
     	@RequestMapping("SRYearList.json")
     	@ResponseBody
     	public List<Integer> SRYearListJson(HttpSession session) {
     		String companyCode = "347-88-00867";
     		return salesMapper.SRYearList(companyCode);
     	}
     	
     	@RequestMapping("SRMonthList.json")
     	@ResponseBody
     	public List<Integer> SRMonthListJson(HttpSession session, String year) {
     		year = year.substring(2);
     		String companyCode = "347-88-00867";
     		return salesMapper.SRMonthList(year, companyCode);
     	}
     	
     	@RequestMapping("test")
     	public void test() {
     		
     	}
         
}