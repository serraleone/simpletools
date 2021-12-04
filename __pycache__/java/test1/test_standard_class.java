package test1;

public class test_standard_class {
    public static void main(String[] args) {
        standard_class s1 = new standard_class();
        s1.setName("许美玲");
        s1.setAge(26);
        s1.show();
        
        // 使用构造参数
        standard_class s2 = new standard_class("许美玲", 26);
        s2.show();
    }
}
