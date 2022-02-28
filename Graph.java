public class Graph{
    private int anzahlKnoten;
    private Knoten[] knoten;
    private int[][] matrix;
    private boolean besucht[];
    /*
     * Initialisiert den Graph anhand der geg maximalen Anzahl von Knoten die verwaltet werden können
     * Setzt alle Kanten auf MIN_VALUE
     */
    public Graph(int max){
        knoten = new Knoten[max];
        matrix = new int[max][max];
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                matrix[i][j] = Integer.MIN_VALUE;
            }
        }
    }
    /*
     * Fügt einen neuen Knoten ein in den Knotenarray
     */
    public void knotenEinfuegen(Knoten neu){
        knoten[anzahlKnoten] = neu;
        anzahlKnoten++;
    }
    /*
     * Fügt Gewichte in die Adjazenzmatrix ein
     */
    public void kanteEinfuegen(String anfang, String ende, int value ){
        int anfangNummer = knotenSuchen(anfang);
        int endeNummer = knotenSuchen(ende);
        matrix[anfangNummer][endeNummer] = value;
    }
    /*
     * Sucht die Nummer des geg. Knotens anhand des bezeichners.
     */
    public int knotenSuchen(String name){
        for(int i = 0; i <anzahlKnoten; i++){
            if(knoten[i].bezeichnerGeben() == name){
                return i;
            }
        }
        return -1;
    }
    
    public void besuchen(int knotenNummer){
        besucht[knotenNummer] = true;
        System.out.print(knoten[knotenNummer].bezFormatGeben(6));
        
        for(int abzweig = 0; abzweig < anzahlKnoten; abzweig++){
             if((matrix[knotenNummer][abzweig] > Integer.MIN_VALUE) && (besucht[abzweig] == false)){
                    besuchen(abzweig);
                }
        }
        System.out.println("    " + knoten[knotenNummer].bezFormatGeben(6) + " fertig");
    }
    public void tiefensuche(String startKnoten){
        besucht = new boolean[anzahlKnoten];
        int startNummer = knotenSuchen(startKnoten);
        if(startNummer != -1){
            for(int i = 0; i < anzahlKnoten; i++){
                besucht[i] = false;
            }
            besuchen(startNummer);
        }
        
    }

}