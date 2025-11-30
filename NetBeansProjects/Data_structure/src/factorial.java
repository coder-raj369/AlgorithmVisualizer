/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author rajpandit
 */
public class factorial {
    static long factorial (int n){
        if (n == 0 || n == 1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }
    
    public static void main(String[] args){
        Scanner  sca = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sca.nextInt();
        if (num < 0) {
            System.out.println("Factorial doesn't exist for negative numbers.");
        } 
        else{
            long result = factorial(num);
            System.out.println("Factorial of " + num + " is " + result);
        }
        
        sca.close();
    }

} 
