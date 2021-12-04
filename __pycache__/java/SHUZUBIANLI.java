import java.util.Scanner;

public class SHUZUBIANLI {
    public static void main(String[] args){
    int[] arr = new int[5];
    Scanner sc = new Scanner(System.in);
    for(int x = 0; x < 5; x++){
        arr[x] = sc.nextInt();
    }

    bianli(arr);

    }

    public static void bianli(int[] arr){
        System.out.print("[");

        for(int i = 0; i < arr.length; i++){
            if(i < arr.length-1){
                System.out.print(arr[i] + ", ");
            }else{
                System.out.println(arr[i] + "]");
            }
        }
    }

}
