public class Testklasse{
    public Testklasse(){
       knotenEinfuegenGen(11);
       
    }
    public void graph1(){
        Graph graph = new Graph(6);
    
    }
    public void graph2(){
        Graph graph = new Graph(11);
    }
    public void knotenEinfuegenGen(int max){
        for(int i = 0; i < max; i++ ){
            char buchstabe = (char) ('a' + i);
             System.out.println("graph.knotenEinfuegen(" + buchstabe +  ") = new Knoten("+ buchstabe+");");
        }
    }
    public void kantenEinfuegenGen(int kantenAnzahl){
        for(int i = 0; i < kantenAnzahl; i++ ){
             System.out.println("graph.kantenEinfuegen()");
        }
    }
}