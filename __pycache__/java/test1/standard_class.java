package test1;

public class standard_class {
    
    // 成员变量
    private String name;
    private int age;

    // 构造方法
    public standard_class(){}

    public standard_class(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 成员方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println(name+","+age);
    }
}
