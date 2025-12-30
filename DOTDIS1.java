import java.util.*;
public class DOTDIS1 {

    static final int MAX = 50;

    static String[] names = new String[MAX];
    static String[] categories = new String[MAX];
    static String[] municipalities = new String[MAX];
    static double[] entranceFees = new double[MAX];

    static int count = 10;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        initializeData();

        int choice;
        do {
            System.out.println("\n--- DOTDIS MENU ---");
            System.out.println("1. Add Tourist Destination");
            System.out.println("2. Search Destination by Name");
            System.out.println("3. Edit Destination Information");
            System.out.println("4. Display All Tourist Destinations");
            System.out.println("5. Compute Average Entrance Fee");
            System.out.println("6. Exit Program");

            choice = getMenuChoice();

            switch (choice) {
                case 1: addDestination(); break;
                case 2: searchDestinationByName(); break;
                case 3: editDestination(); break;
                case 4: displayAllDestinations(); break;
                case 5: computeAverageEntranceFee(); break;
                case 6: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    // ---------------- INITIAL DATA ----------------
    static void initializeData() {
        names[0] = "Dahican Beach"; categories[0] = "Beach"; municipalities[0] = "Mati City"; entranceFees[0] = 20;
        names[1] = "Aliwagwag Falls"; categories[1] = "Waterfall"; municipalities[1] = "Cateel"; entranceFees[1] = 100;
        names[2] = "Pusan Point"; categories[2] = "Landmark"; municipalities[2] = "Caraga"; entranceFees[2] = 30;
        names[3] = "Sleeping Dinosaur"; categories[3] = "Landmark"; municipalities[3] = "Mati City"; entranceFees[3] = 0;
        names[4] = "Mount Hamiguitan"; categories[4] = "Mountain"; municipalities[4] = "San Isidro"; entranceFees[4] = 200;
        names[5] = "Subangan Museum"; categories[5] = "Museum"; municipalities[5] = "Mati City"; entranceFees[5] = 50;
        names[6] = "Cape San Agustin"; categories[6] = "Beach"; municipalities[6] = "Governor Generoso"; entranceFees[6] = 30;
        names[7] = "Banaybanay Beach"; categories[7] = "Beach"; municipalities[7] = "Banaybanay"; entranceFees[7] = 20;
        names[8] = "Curtain Falls"; categories[8] = "Waterfall"; municipalities[8] = "Mati City"; entranceFees[8] = 50;
        names[9] = "Balite Hot Spring"; categories[9] = "Hot Spring"; municipalities[9] = "San Isidro"; entranceFees[9] = 30;
    }

    // ---------------- ADD ----------------
    static void addDestination() {
        in.nextLine();

        if (count >= MAX) {
            System.out.println("Destination list is full.");
            return;
        }

        System.out.print("Enter destination name: ");
        String name = in.nextLine();
        if (!validateName(name)) return;

        System.out.print("Enter category: ");
        String category = in.nextLine();
        if (!validateCategory(category)) return;

        System.out.print("Enter municipality: ");
        String municipality = in.nextLine();
        if (!validateMunicipality(municipality)) return;

        System.out.print("Enter entrance fee: ");
        double fee = in.nextDouble();

        names[count] = name;
        categories[count] = category;
        municipalities[count] = municipality;
        entranceFees[count] = fee;
        count++;

        System.out.println("Destination added successfully.");
    }

    // ---------------- SEARCH ----------------
    static void searchDestinationByName() {
        in.nextLine();
        System.out.print("Enter name to search: ");
        String search = in.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (names[i].toLowerCase().contains(search)) {
                System.out.println(names[i] + " | " + categories[i] + " | " +
                        municipalities[i] + " | Fee: " + entranceFees[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No destination found.");
    }

    // ---------------- EDIT ----------------
    static void editDestination() {
        in.nextLine();
        System.out.print("Enter destination name to edit: ");
        String search = in.nextLine();

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(search)) {
                System.out.print("New entrance fee: ");
                entranceFees[i] = in.nextDouble();
                in.nextLine();
                System.out.print("New category: ");
                categories[i] = in.nextLine();
                System.out.println("Updated successfully.");
                return;
            }
        }
        System.out.println("Destination not found.");
    }

    // ---------------- DISPLAY ----------------
    static void displayAllDestinations() {
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + " | " + categories[i] + " | " +
                    municipalities[i] + " | Fee: " + entranceFees[i]);
        }
    }

    // ---------------- AVERAGE ----------------
    static void computeAverageEntranceFee() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += entranceFees[i];
        System.out.println("Average Entrance Fee: " + (sum / count));
    }

    // ---------------- VALIDATION ----------------
    static boolean validateName(String s) { return s.matches("[A-Za-z ]+"); }
    static boolean validateCategory(String s) { return s.matches("[A-Za-z ]+"); }
    static boolean validateMunicipality(String s) { return s.matches("[A-Za-z ]+"); }

    static int getMenuChoice() {
        System.out.print("Enter choice: ");
        while (!in.hasNextInt()) {
            in.next();
            System.out.print("Enter number only: ");
        }
        return in.nextInt();
    }
}
