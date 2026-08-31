import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AquariumApp {

    public static void main(String[] args) {

        SeaCreature[] tank = new SeaCreature[8];

        // Two starter creatures. //only prints the first thing to throw an exception?
        try {
            tank[0] = new Fish("Nemo", 4, 3, 1, "><>", "orange");

        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
        try {
            tank[1] = new Fish("Dory", 30, 2, -2, "><((('>", "blue");

        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
          try {
            tank[2] = new Fish("Chloe", 15, 1, -3, "><({{(º>", "red");
        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
          try {
            tank[3] = new Shark("Ava", 23, 4, 1, "green");
        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
         try {
            tank[4] = new Squid("Vivi", 7, 1, 2, "blue");
        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
         try {
            tank[5] = new Squid("972", 1, 1, 2, "red");
        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
         try {
            tank[6] = new Fish("InvalidFish", -3, 1, 2, "><((('>", "yellow");

        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
          try {
            tank[7] = new Shark("BadShark", -3, 1, 2, "blue");

        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        }
       
        // =====================================================
        // STUDENT TODO
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3": //assisted by chat gpt for import statements and how to use sleep
                    System.out.println("Free Swim starting...");
                    
                    for (int i = 0; i < 18; i++) {
                        aquarium.advanceTurn();
                        aquarium.display();

                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                    
                    System.out.println("Free Swim ended!");
                    break;
                case "4":
                    aquarium.listCreatureDetails();
                    break;

                case "5":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose 1, 2, 3, 4 or 5.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. Free Swim");
        System.out.println("4. View Creature Details");
        System.out.println("5. Quit");
    }
}
