package Solutions;

//Skriv en funktion som översätter från rövarspråket till svenska.
public class RovarspraketTillbaka {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder("Hohejoj popå dodigog!");
        System.out.println("Rövarspråket: " + input);
        StringBuilder translated = translateBack(input);
        System.out.println("Svenska: " + translated);
    }

    public static StringBuilder translateBack (StringBuilder input){
        StringBuilder translated = new StringBuilder(" ");
        for(int i = 0; i<input.length(); i++){
            //Om en bokstav är 'o' och bokstaven innan den och efter den är lika (ignore case), då är den en signal för Rövarspråket, och bokstaven samt en efter den måste borttas
            if(input.charAt(i) == 'o' && Character.toLowerCase(input.charAt(i-1)) == Character.toLowerCase(input.charAt(i+1))){
                input.delete(i, i+1);
            }else{ // Annars lägga(kopiera) bokstaven till en ny stringbuilder, translated
                translated = translated.append(input.charAt(i));
            }
        }
        return translated;
    }
}
