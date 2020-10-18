package Solutions;

//På ruta 1 på ett schackbräde lägger vi ett riskorn, på ruta 2 lägger vi två
//riskorn, på ruta 3 lägger vi fyra riskorn osv. Vi dubblar mängden riskorn för
//varje ruta. På vilken ruta är man när hela schackbrädet innehåller minst x
//antal riskorn. Skriv en funktion som beräknar detta.
//Exempel:
//whatSquare(5) returnerar 3, whatSquare(8) returnerar 4,
//whatSquare(1000000) returnerar 20.
public class Riskorn {
    public static void main(String[] args) {
        int antal = 1000000;
        System.out.println("reusult: " + whatSquare(antal));
    }

    public static int whatSquare(int antal){
        int square = 0;
        for(int i = 0; i<64; i++){ // ett schackbräde har 64 rutor
            if(Math.pow(2, i) > antal){ // hitta först ruta nummer(en tempo num i början) med som kan "2 to the power" och högre än antalet
                square = i; //då kopiera den till ruta nummer
                return square;
            }
        }
        return square;
    }
}
