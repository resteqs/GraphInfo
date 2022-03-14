public class Graph{

    private int anzahlKnoten;
    private Knoten[] knoten;
    private int[][] matrix;
    private boolean[] besucht;
    private int[] distanz;
    
    public Graph(int maxGroese){
        matrix = new int[maxGroese][maxGroese];
        knoten = new Knoten[maxGroese];
        standartWerte(maxGroese);
       
    }

    public void knotenEinfuegen(String s){
        if(anzahlKnoten < knoten.length ){
            if(istBezeichnerEnthalten(s) == false){
                knoten[anzahlKnoten] = new Knoten(s);
                anzahlKnoten = anzahlKnoten +1;
            }
        }
    }

    public boolean istBezeichnerEnthalten(String s){

        for(int i = 0; i < anzahlKnoten; i++){
            if(knoten[i].bezeichnerGeben() == s){
                return true;
            }
        }
        return false;
    }

    public void standartWerte(int x){
        int j = 0;
        for(j= 0; j < x; j++){
            for(int i = 0; i < x; i++){
                matrix[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void kanteEinfuegen(String anfang, String ende, int gewicht){
        int anfangNum = 0;
        int endeNum = 0;
        for(int i = 0; i < anzahlKnoten; i++ ){
            if(knoten[i].bezeichnerGeben() == anfang){
                anfangNum = i;
            }
            if(knoten[i].bezeichnerGeben() == ende){
                endeNum = i;
            }
        }
        matrix[anfangNum][endeNum] = gewicht;
    }
    
    public int knotenNummer(String vergleich){
        for(int i=0; i < anzahlKnoten; i++){
            if(knoten[i].bezeichnerGeben() == vergleich){
                return i;
            }
        }
        return -1;
    }
    
    public void tiefensuche(String startKnoten){
        int startNummer;
        startNummer = knotenNummer(startKnoten);
        
        if(startNummer != -1){
            for(int i = 0; i <= anzahlKnoten -1; i++){
                besucht[i] = false;
            }
            besuchen(startNummer);
        }
    }
    public void besuchen (int knotenNummer){
        besucht[knotenNummer] = true;
        System.out.println(knoten[knotenNummer].bezeichnerGeben() + ";");
        for(int i = 0; i <= anzahlKnoten-1; i++){
            if(matrix[knotenNummer][i] > Integer.MIN_VALUE && besucht[i] == false){
                besuchen(i);
            }
        }
        System.out.println(knoten[knotenNummer].bezeichnerGeben() + "abgeschlossen");
    }
    public int minKnoten(){
        int minPos = 0;
        int minWert = Integer.MAX_VALUE;
        
        
        for(int k = 0; k < anzahlKnoten; k++){
            if(besucht[k] != false && minWert > distanz[k]){
                minWert = distanz[k];
                minPos = k;
            }
        }
        return minPos;
    }
    
    public void kuerzesterWeg(String startKnoten, String zielKnoten){
            int startNummer = knotenNummer(startKnoten);
            int zeilNummer = knotenNummer(zielKnoten);
            int knotenNummer;
            int neueDistanz;
            
            for(int k = 0; k < anzahlKnoten; k++){
                besucht[k] = false;
                distanz[k] = Integer.MAX_VALUE;
            }
            distanz[startNummer] = 0;
            kommtVon[startNummer] = startNummer;
            
            
    }
   
    
}