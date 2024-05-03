public class Gadget
{
   private String model;   // string value
   private double price;  // = price in £
   private int weight;   // = grams int
   private String size; // the size (e.g "71mm x 137mm x9mm") string
                       //The size parameter accepts a string value, allowing the user to define the unit as well.                                               
                                        
    public Gadget(String model, double price, int weight, String size)
   {
       this.model = model; 
       this.price = price; 
       this.weight = weight;     // initalizing the parent class
       this.size = size; 
   }
   
   public String getModel()
   {
     return model;
   }
   
   public double getPrice()
   {
       return price;
   }
   
  
   public int getWeight()
   {
       return weight;
   }
     
   public String getSize()
   {
       return size;
   }
   
   public void display()
   {
       System.out.println ("Model: "+model+"\n Price: £" +price+"\n Weight: "+weight+"grams \n Size: " +size); 
   }
}