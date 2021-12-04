import java.util.Scanner;

public class SANGEHESHANG{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);  

        System.out.println("Please write the hight of the first person:");
        int a = sc.nextInt();
        System.out.println("Please write the hight of the second person:");
        int b = sc.nextInt();
        System.out.println("Please write the hight of the third person:");
        int c = sc.nextInt();

        int temph = a > b ? a : b;
        int maxh = temph > c ? temph : c;

        System.out.println(maxh);
    }
}


