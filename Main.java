package exercise;

public class Main {
    public static void main(String[] args) {
        System.out.println("Jaya Sonica S");
        System.out.println("2117240070125");
        Shape tc1 = new Circle(5);
        tc1.area();  

       
        Shape tc2 = new Rectangle(10, 5);
        tc2.area();  
        
        Shape tc3 = new Shape();
        tc3.area();   
        
        Shape tc4 = new Circle(0);
        tc4.area();   
        
        Shape tc5 = new Rectangle(10, 0);
        tc5.area();
}}
