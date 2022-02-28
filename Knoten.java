public class Knoten{
    private String bezeichner;
    public Knoten(String name){
        bezeichner = name;
    }
    public String bezeichnerGeben(){
        return bezeichner;
    }
    public String bezFormatGeben(int anzahl){
        String s = bezeichner;
        for(int i = 0; i < anzahl; i++){
            s = s + " ";
        }
        return s;
    }
    
}