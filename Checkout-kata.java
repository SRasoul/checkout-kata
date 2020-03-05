package marketcheckout;
import java.util.ArrayList;
import java.util.Scanner;

//Blueprint class for all items
class Items {

//Attributes
    String itemName;
    double price;
    boolean isOnOffer;
    double offerPrice;
    int perQuantaty ;
   
   //methods and constructers
    public Items(String name, double price, boolean  isOnOffer,
            double offerPrice, int perQuantaty) {
    this.itemName = name;
    this.price = price;
    this.isOnOffer = isOnOffer;
    this.offerPrice = offerPrice;
    this.perQuantaty = perQuantaty;
    
  }

//Main Class 

public class MarketCheckOut {

    
    static double calculateCost(double price, double offerPrice, 
                boolean isOnOffer, int itemSold, int quantityPerOffer)
        {
            double result;
            if(isOnOffer == true)
            {
              result = ((itemSold / quantityPerOffer) * offerPrice) +
                       ((itemSold % quantityPerOffer) * price); 
            }else
            {
              result = itemSold * price;  
            }
            
            return result;
                
        } 


public static void main(String[] args) {
        
       //creating objects
        Items A99 = new Items("Banana", 0.5, true,  1.3,  3);
        Items B15 = new Items("Apple", 0.3, true,  0.45, 2);
        Items C4 = new Items("item3" , 0.60, false, 0,   0);
        Items T34 = new Items("item4", 0.99, false, 0,   0);
        
        
        //putting objects in one container
        ArrayList <Items> items  = new ArrayList <> ();
        
       
        items.add(A99);
        items.add(B15);
        items.add(C4);
        items.add(T34);
        
        //Extention algorithm for expanding by creating more items
        
        //creat Bin counters for counting items sold per checkout
        int listSize = items.size();
        System.out.println(listSize);
       
        int[] bin = new int[listSize];
        
        for(int i= 0; i < listSize; i++ )
        {
            bin [i] = 0;
        
        }
        
        System.out.println( "If you ready for shoping please type yes " );
        Scanner myScanner = new Scanner(System.in);
        String answer = myScanner.nextLine();
        
        
        
        
        //output the options (items)
        
       if (answer.equalsIgnoreCase("yes") )
        {
           System.out.println( " To add items to the basket, please add the "
                   + "following numbers in any order" ); 
           for(int i= 0; i < listSize; i++ )
              {
         System.out.println(i + " for :" + items.get(i).itemName);
               }
         System.out.println( " type -1 when you finished ");
        }
        
        //Read from keyboard and finish 
        
         int number;
        
        
        do {   number = myScanner.nextInt(); 
                if(number >= 0 && number < listSize)
                {bin[number]++;
                
                }
              
        } while (number >= 0 && number < listSize );
        
        //print out the basket items
        for(int i= 0; i < listSize; i++ )
                          {
         System.out.println( " Number of " + items.get(i).itemName +
                 " sold is : " + bin[i] );
               }    
        
        //calculate the cost of items
        
       double totalSold =0.0;
        for(int i= 0; i < listSize; i++ )
                          { 
         System.out.println( 
                 " Number of " + items.get(i).itemName +
                 "  sold is : " + bin[i] + " for the price: " + 
                 calculateCost(
                         items.get(i).price,
                         items.get(i).offerPrice, 
                         items.get(i).isOnOffer, bin[i], 
                         items.get(i).perQuantaty));
                         
                         
        calculate the totall
                   totalSold =  totalSold + calculateCost(
                         items.get(i).price, 
                         items.get(i).offerPrice, 
                         items.get(i).isOnOffer, bin[i], 
                         items.get(i).perQuantaty);
              }
                  System.out.println( "Total sold is :" + totalSold);
        
    }

        }
