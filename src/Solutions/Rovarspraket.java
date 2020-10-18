package Solutions;


//Skriv en funktion som översätter från svenska till rövarspråket.
//Rövarspråket innebär aL man ersätter varje konsonant med sig själv + “o” +
//sig själv igen.
//Exempel:
//“Hej på dig!” översätts till “Hohejoj popå dodigog!”.

public class Rovarspraket {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder("Hej på dig!");
        System.out.println("Svenska: " + input);
        StringBuilder translated = translate(input);
        System.out.println("Rövarspråket:" + translated);
    }

    public static StringBuilder translate (StringBuilder input){
        StringBuilder translated = new StringBuilder(" ");
        for(int i = 0; i<input.length(); i++){
            //Om input.charAt(i) tillhör alphabet, kontrollera om det är en vokal eller konsonant (för både lowercase och uppercase)
            if((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i)>='A' && input.charAt(i)<='Z') ){
                if(input.charAt(i) == 'a' || input.charAt(i) == 'A'
                        || input.charAt(i) == 'e' || input.charAt(i) == 'E'
                        || input.charAt(i) == 'i' || input.charAt(i) == 'I'
                        || input.charAt(i) == 'o' || input.charAt(i)== 'O'
                        || input.charAt(i) == 'u' || input.charAt(i) == 'U'
                        || input.charAt(i) == 'ö' || input.charAt(i) == 'Ö'
                        || input.charAt(i) == 'ä' || input.charAt(i) == 'Ä'
                        || input.charAt(i) == 'å' || input.charAt(i) == 'Å'){
                    translated = translated.append(input.charAt(i)); // lägga(kopiera) bara bokstaven om den är en vokal

                } else { // lägga(kopiera) bokstaven samt o och en samma bokstav till (måste bli lowercase)
                    translated = translated.append(input.charAt(i));
                    translated = translated.append('o');
                    translated = translated.append(Character. toLowerCase(input.charAt(i)));
                }
            }else { // om input.charAt(i) inte tillhör alphabet, exempelvis " " eller en interpunktion, lägga(kopiera) bara input.charAt(i) till
                translated = translated.append(input.charAt(i));
            }
        }

        return translated;
    }

}
