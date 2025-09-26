import java.util.Scanner;
import java.util.ArrayList;

class User {
    String name, password, phone;

    public User(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
}

public class ArrayListProgram {
    private static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");
            System.out.print("Your Choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                inputData(input);
            } else if (choice == 2) {
                showData();
            } else if (choice == 3) {
                deleteData(input);
            } else if (choice == 4) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Masukkan 1-4");
            }
        }
        input.close();
    }

    public static void inputData(Scanner input) {
        String name, password, phone;

        do {
            System.out.print("Masukkan nama (maks 10 karakter): ");
            name = input.next();
            if (name.length() > 10 || !name.matches("[a-zA-Z]+")) {
                System.out.println("Nama harus terdiri dari huruf dan tidak lebih dari 10 karakter. Coba lagi");
            }
        } while (name.length() > 10 || !name.matches("[a-zA-Z]+"));
        
        do {
            System.out.print("Masukkan password (maks 10 karakter): ");
            password = input.next();
            if (password.length() > 10) {
                System.out.println("Password melebihi 10 karakter. Coba lagi");
            }
        } while (password.length() > 10);
        
        do {
            System.out.print("Masukkan nomor telepon (tepat 10 digit): ");
            phone = input.next();
            if (phone.length() != 10 || !phone.matches("\\d+")) {
                System.out.println("Nomor telepon harus tepat 10 digit. Coba lagi");
            }
        } while (phone.length() != 10 || !phone.matches("\\d+"));

        userList.add(new User(name, password, phone));
        System.out.println("Data berhasil ditambahkan");
    }

    public static void showData() {
        if (dataCount == 0) {
            System.out.println("Tidak ada data");
            return;
        }
        System.out.printf("\n|%-4s|%-12s|%-12s|%-12s|\n", "No", "Nama", "Password", "No Telp");
    
        for (int i = 0; i < dataCount; i++) {
            System.out.printf("|%-4d|%-12s|%-12s|%-12s|\n", (i + 1), nama[i], pw[i], no_telp[i]);
        }
    }

    public static void deleteData(Scanner input) {
        if (userList.isEmpty()) {
            System.out.println("Tidak ada data");
            return;
        }
        System.out.print("Input data number to be deleted: ");
        int deleteIndex = input.nextInt() - 1;
        
        if (deleteIndex < 0 || deleteIndex >= userList.size()) {
            System.out.println("Nomor data tidak valid. Silakan coba lagi");
            return;
        }
        
        // Remove the element at the specified index
        userList.remove(deleteIndex);
        System.out.println("Data berhasil dihapus");
    }
}