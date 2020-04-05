package com.example.SpringBootCrudMongoDB.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

	public String getBracket(int income)
	{
		if(income<1000)
	     return "LOW";
		else if(income > 1000)
			return "High";
		else 
			return "Medium";
		
	}
	public int countA(String word)
	{
		int count=0;
		for(int i=0;i<word.length();i++)
		{
			if(word.contains("A"))
			{
				count++;
			}
		}
		return count;
	}
	public boolean compareTwoString(String s1,String s2)
	{
		if(s1.equalsIgnoreCase(s2))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[] addOneTOArr(int[] arr) {
		// TODO Auto-generated method stub
		int[] output=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			output[i]=arr[i]+1;
		}
		return output;
	}
	
		
	public void performance() {
		for(int i=0;i<100;i++)
		{
		}
		System.out.println("Test Performance");
		}
	}

