import java.util.HashMap;
import java.util.Map;

/**
 * Calculates money left each money. Uses a setting file to store the results. Prints the expenses on one
 * side of the screen and the income on the other.
 * 
 * @author (Tony Youbi) 
 * @version (v 0.001a)
 */
public interface expenseCalculator
{
    /**
     *Inserts expenses to the list
     * 
     * @param name the name of the item
     * @param  expense   The money being spent
     
     */
    void insertE (String name, Double expense);
    
    
    /**
     * 
     * Inserts income to the list
     * 
     * @param name of the income
     * @income value of the income
     */
    void insertI (String name, Double income);
    
    /**Calculates and returns total expenses
     * 
     * @return The total Expenses
     */
    double calculateE();
    
    
    
    
    /**
     * 
     * @return The total money left
     */
    double moneyLeft();
}
