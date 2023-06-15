package onlinesales.task1;

import java.util.HashMap;
import java.util.Random;

public class EventSimulator {

    //this simulator method has logic to select among key inputs in main method , and their likely chances to occur in totalOccurrences.

    // the simulator method uses a random number to select an outcome based on their probabilities. It iterates through the 'hm' map,
    // accumulating the probabilities until it finds an outcome whose cumulative probability comes nearer to the generated random number.

    // main thing to note that event occurrence is totally 'biased' on hashmap input value (that is probability of event provided in input) ,
    // higher the number higher the chances of occurring
    static Object simulator(HashMap<Object, Integer> hm) {

        int randomNumber = new Random().nextInt(100);
        int growingProbability = 0;

        for (HashMap.Entry<Object, Integer> inputProbabilities : hm.entrySet()) {
            growingProbability = growingProbability + inputProbabilities.getValue();
            if (randomNumber <= growingProbability) {
                return inputProbabilities.getKey();
            }
        }

        throw new RuntimeException ("400 Bad Request");
    }
    static void passHashMap(HashMap<Object,Integer> hm){
        int totalOccurrences = 1000;
        HashMap<Object, Integer> occurrenceCount = new HashMap<>();

        for (int i = 0; i < totalOccurrences; i++) {
            Object obj = simulator(hm);
            Integer count = occurrenceCount.get(obj);
            if (count == null) {
                occurrenceCount.put(obj, 1);
            } else {
                occurrenceCount.put(obj, count + 1);
            }
        }

        //print occurrences
        for (HashMap.Entry<Object, Integer> entry : occurrenceCount.entrySet()) {
            System.out.println("Chances to occur " +entry.getKey() + " is " +entry.getValue() + " times.");
        }
    }

    public static void main(String[] args) {

        System.out.println("\n Simulation for Dice with hard coded inputs with 1000 occurrence \n");
        // hard coded outcomes and their probabilities
        HashMap<Object, Integer> hmDice = new HashMap<>();
        hmDice.put(1,10);
        hmDice.put(2,30);
        hmDice.put(3,15);
        hmDice.put(4,15);
        hmDice.put(5,30);
        hmDice.put(6,0);

        passHashMap(hmDice);

        System.out.println("\n Simulation for Coin with hard coded inputs with 1000 occurrence \n");

        HashMap<Object, Integer> hmCoin = new HashMap<>();
        hmCoin.put("head",35);
        hmCoin.put("tail",65);

        passHashMap(hmCoin);

    }
}


