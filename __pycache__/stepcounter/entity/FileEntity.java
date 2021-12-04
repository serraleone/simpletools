public class FileEntity {
    
    private String num;
    private String name;
    
    public FileEntity(String num, String name){
        this.num = num;
        this.name = name;     
    }

    public String getNum(){
        return this.num;
    }

    public String getName(){
        return this.name;
    }
}