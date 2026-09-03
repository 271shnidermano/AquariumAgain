import java.util.Scanner; 
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;




public class AquariumApp {

    public static void main(String[] args) {

        SeaCreature[] tank = new SeaCreature[8];

        // Two starter creatures. //only prints the first thing to throw an exception?
       
       try {
        loadCreatures("Creature.txt");
        } catch (InvalidCreatureException e) {
            System.out.println("Invalid creature: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not load creatures: " + e.getMessage());
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
private static SeaCreature[] loadCreatures(String fileName)  throws IOException {

    FileReader file = new FileReader(fileName);
    Scanner input = new Scanner(file);

    int numberOfCreatures = input.nextInt();
    input.nextLine();

    SeaCreature[] tank =  new SeaCreature[numberOfCreatures];
    
    for (int i = 0; i < tank.length; i++) {
        String line = input.nextLine();
        tank[i] = createCreature(line);
    }
    input.close();
    return tank;
}

private static SeaCreature createCreature(String line)
{
    Scanner data = new Scanner(line);
    data.useDelimiter(",");
    String type = data.next();
    String name = data.next();
    int position = data.nextInt();
    int speed = data.nextInt();
    int direction = data.nextInt();
    String color = data.next();
  
    if (type.equalsIgnoreCase("Fish")) 
    {
        String symbol = data.next();
     return new Fish(name, position, speed, direction, symbol);
    }
    else if(type.equalsIgnoreCase("Shark"))
    {
        return new Squid(name, position, speed, direction);
    }
    else
    {
        return new Shark(name, position, speed, direction);
    }
    
}
        