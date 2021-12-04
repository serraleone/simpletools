import java.util.Scanner;

public class ODD_OR_EVEN{

    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        if(a%2 == 0){
            System.out.println("This is an odd");
        }else{
            System.out.println("This is an even");
        }
    }
}