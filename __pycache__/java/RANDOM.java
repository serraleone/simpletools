import java.util.Random;
import java.util.Scanner;

public class RANDOM {
    public static void main(String[] args){
        Random r = new Random();
        int number = r.nextInt(10);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the number and press Enter key");
        int a = sc.nextInt();
        
        while(a != number){
            if(a < number){
                System.out.println("The number you guessed is less than the answer");
                a = sc.nextInt();
                continue;
            }else if(a > number){
                System.out.println("The number you guessed is more than the answer");
                a = sc.nextInt();      
                continue;         
            }
        }

        System.out.println("you won the game and congratuations!");
        System.out.println("answer is " + number);
    }  
}