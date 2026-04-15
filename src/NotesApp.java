import java.io.*;
import java.util.Scanner;

public class NotesApp {

    public static void addNote(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("notes.txt", true);
            System.out.print("Enter note: ");
            sc.nextLine();
            String note = sc.nextLine();

            fw.write(note + "\n");
            fw.close();

            System.out.println("Note saved");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public static void viewNotes() {
        try {
            File file = new File("notes.txt");

            if (!file.exists()) {
                System.out.println("No notes found");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\nYour Notes:");

            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nNotes App");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
            }

        } while (choice != 3);

        sc.close();
    }
}