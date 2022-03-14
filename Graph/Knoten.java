public class Knoten{
    private String bezeichner;
    public Knoten(String neuerBez){
        bezeichner = neuerBez;
    }
    public String bezeichnerGeben(){
        return bezeichner;
    }
    public String bezFormatGeben(int formatLength){
        String tempBez = bezeichner;
        for(int l = bezeichner.length(); l < formatLength; l++){
               tempBez = tempBez + " ";
        }
        return tempBez.substring(0, formatLength);
    }
}