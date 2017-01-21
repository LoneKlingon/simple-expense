/*
    Simple Expense Calculator Program with Gui
    Author: Anthony Youbi Sobodker
    Copyright 2017
*/


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Write a description of class Expense here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Expense implements expenseCalculator
{
	
    // instance variables - replace the example below with your own
    private int x;
    
    private HashMap<String, Double> expense = new HashMap<String, Double>();
    
    private HashMap<String, Double> income = new HashMap<String, Double>();

    
	private File incomeFile = new File ("income.txt"); //name of the temporary income file
	private PrintWriter incomeWriter; //writes to the income file
	
	
	private String expenseFile = "expense.txt"; //name of the temporary expense file
	private PrintWriter expenseWriter;
	
	private HashMap<String, Double> fixedIncome = new HashMap<String, Double>();
	private HashMap<String, Double> fixedExpense = new HashMap<String, Double>();
	
    /**
     * Constructor for objects of class Expense
     */
    public Expense()
    {
    	openFile();
    	
    	
    }
    /**
     * Opens the file
     */
    public void openFile(){
    	//opens income file
    	try {
			incomeWriter = new PrintWriter(new FileWriter(incomeFile, true)); //true so that it doesn't overwrite file contents
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//opens expense file
    	try {
			expenseWriter = new PrintWriter(new FileWriter(expenseFile, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    
      /**
     *Inserts expenses to the list
     * 
     * @param name the name of the item
     * @param  expense   The money being spent
     
     */
    public void insertE (String name, Double e){
        
        expense.put(name, e);
        expenseWriter.println(name + ": " + income);
        expenseWriter.flush();
        
        
    }
    
    /**
     * Checks to see if a string is a double
     * 
     * @param str The String entered
     * @return whether or not the string entered is a double
     * 
     */
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
      /**
     * 
     * Inserts income to the list
     * 
     * @param name of the income
     * @income value of the income
     */
    public void insertI (String name, Double income){
        
        this.income.put(name, income);
        incomeWriter.println(name + ": " + income);
        incomeWriter.flush();
    }
    
    /**Calculates and returns total expenses
     * 
     * @return The total Expenses
     */
    public double calculateE(){
        
        
        double totalExpense = 0;
        
        
       for (String key: expense.keySet())
       {
           totalExpense+=expense.get(key);
       }
        
        return totalExpense;
    }
    
    /**
     * Calculates the total Income
     * 
     * @return The total income
     */
    public double calculateI(){
       
        double totalIncome = 0;
        
        for (String key: income.keySet())
       {
           totalIncome+=income.get(key);
           
           
       }
        
        return totalIncome;
    }
    /**
     * Adds fixed incomes to a file 
     * 
     * @param name the name of the fixed income
     * @param amount the amount to be added
     */
    public void addFixedIncome(String name, double amount){
    	
    	fixedIncome.put(name, amount);
    	
    	File file = new File("serialized_hashmap");   
    	FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
    	ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}           
    	try {
			oos.writeObject(fixedIncome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	try {
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
     /**
     * 
     * @return The total money left
     */
    public double moneyLeft(){
        
     double left;
     
     left=  calculateI() - calculateE();
     
     return left;
    }
    
    
    public static void main (String [] args){
    	
    	
    }
    
}
