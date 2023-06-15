package onlinesales.task1;


import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class EventSimulatorTest {
    @Test
    public void testSimulatorForDice() {
        // expected probabilities
        HashMap<Object, Integer> expectedProbabilities = new HashMap<>();
        expectedProbabilities.put(1, 10);
        expectedProbabilities.put(2, 30);
        expectedProbabilities.put(3, 15);
        expectedProbabilities.put(4, 15);
        expectedProbabilities.put(5, 30);
        expectedProbabilities.put(6, 0);

        // total the number of occurrences
        int totalOccurrences = 1000;

        // Create a map to track the occurrence count
        HashMap<Object, Integer> occurrenceCount = new HashMap<>();

        // Perform the simulation
        for (int i = 0; i < totalOccurrences; i++) {
            Object obj = EventSimulator.simulator(expectedProbabilities);
            Integer count = occurrenceCount.get(obj);
            if (count == null) {
                occurrenceCount.put(obj, 1);
            } else {
                occurrenceCount.put(obj, count + 1);
            }
        }

        // Verify the occurrence count matches the expected probabilities with a tolerance of ±10%
        for (HashMap.Entry<Object, Integer> entry : occurrenceCount.entrySet()) {
            Object outcome = entry.getKey();
            Integer actualCount = entry.getValue();
            Integer expectedCount = expectedProbabilities.get(outcome) * totalOccurrences / 100;
            int tolerance = totalOccurrences / 100 * 10; // ±10%
            assertTrue(actualCount >= expectedCount - tolerance && actualCount <= expectedCount + tolerance);
        }
    }


    @Test
    public void testSimulatorForCoinFlip() {
        // Define the expected probabilities
        HashMap<Object, Integer> expectedProbabilities = new HashMap<>();
        expectedProbabilities.put("Head", 35);
        expectedProbabilities.put("Tail", 65);

        // Define the number of occurrences
        int totalOccurrences = 1000;

        // Create a map to track the occurrence count
        HashMap<Object, Integer> occurrenceCount = new HashMap<>();

        // Perform the simulation
        for (int i = 0; i < totalOccurrences; i++) {
            Object obj = EventSimulator.simulator(expectedProbabilities);
            Integer count = occurrenceCount.get(obj);
            if (count == null) {
                occurrenceCount.put(obj, 1);
            } else {
                occurrenceCount.put(obj, count + 1);
            }
        }

        // Verify the occurrence count matches the expected probabilities with a tolerance of ±10%
        for (HashMap.Entry<Object, Integer> entry : occurrenceCount.entrySet()) {
            Object outcome = entry.getKey();
            Integer actualCount = entry.getValue();
            Integer expectedCount = expectedProbabilities.get(outcome) * totalOccurrences / 100;
            int tolerance = totalOccurrences / 100 * 10; // ±10%
            assertTrue(actualCount >= expectedCount - tolerance && actualCount <= expectedCount + tolerance);
        }
    }

}
