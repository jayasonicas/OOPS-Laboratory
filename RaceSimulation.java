package exercise;

// Program Title: Multi-threaded Race Simulation
// Aim: To simulate a race between two threads using Java multithreading.

class Racer extends Thread {
    private String racerName;
    private int sleepTime;  // Time to simulate speed
    
    public Racer(String racerName, int sleepTime) {
        this.racerName = racerName;
        this.sleepTime = sleepTime;
    }
    
    @Override
    public void run() {
        try {
            for (int step = 1; step <= 5; step++) { // race has 5 steps
                System.out.println(racerName + " completed step " + step);
                Thread.sleep(sleepTime); // simulate time between steps
            }
            System.out.println(racerName + " has finished the race!");
        } catch (InterruptedException e) {
            System.out.println(racerName + " was interrupted!");
        }
    }
}

public class RaceSimulation {
    public static void main(String[] args) {
        System.out.println("=== Race Simulation ===");

        // ---------- TC1: Two threads start → Both race together ----------
        System.out.println("\n--- Test Case 1: Two racers, same speed ---");
        Racer racer1A = new Racer("Thread A", 500);
        Racer racer1B = new Racer("Thread B", 500);
        racer1A.start();
        racer1B.start();
        waitForFinish(racer1A, racer1B);

        // ---------- TC2: Sleep time different → One finishes first ----------
        System.out.println("\n--- Test Case 2: Different speeds ---");
        Racer racer2A = new Racer("Thread A", 300);
        Racer racer2B = new Racer("Thread B", 700);
        racer2A.start();
        racer2B.start();
        waitForFinish(racer2A, racer2B);

        // ---------- TC3: Race output varies due to scheduling ----------
        System.out.println("\n--- Test Case 3: Output may vary ---");
        Racer racer3A = new Racer("Thread A", 400);
        Racer racer3B = new Racer("Thread B", 400);
        racer3A.start();
        racer3B.start();
        waitForFinish(racer3A, racer3B);

        // ---------- TC4: Add a third thread ----------
        System.out.println("\n--- Test Case 4: Three racers ---");
        Racer racer4A = new Racer("Thread A", 400);
        Racer racer4B = new Racer("Thread B", 500);
        Racer racer4C = new Racer("Thread C", 600);
        racer4A.start();
        racer4B.start();
        racer4C.start();
        waitForFinish(racer4A, racer4B, racer4C);

        // ---------- TC5: Threads with same sleep → Output may interleave ----------
        System.out.println("\n--- Test Case 5: Interleaving output ---");
        Racer racer5A = new Racer("Thread A", 500);
        Racer racer5B = new Racer("Thread B", 500);
        racer5A.start();
        racer5B.start();
        waitForFinish(racer5A, racer5B);
    }

    // Helper method to ensure all threads finish before moving to next test case
    private static void waitForFinish(Thread... threads) {
        for (Thread t : threads) {
            try {
                t.join(); // Wait for each thread to complete
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting.");
            }
        }
    }
}
