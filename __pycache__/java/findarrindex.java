import java.util.Scanner;

public class findarrindex {
    public static void main(String[] args){
     int[] arr = {11, 22, 33, 44, 55};
     Scanner sc = new Scanner(System.in);
     
     System.out.println("请输入想查找的数字");
     int number = sc.nextInt();

     int index = findarr(arr, number);
     System.out.println("index" + index);
    }

    public static int findarr(int[] arr, int number){
        int index = -1;
        for(int x= 0; x < arr.length; x++){
            if(arr[x] == number){
                index = x;
                break;
            }
        }
        return index;
    }
    
}
