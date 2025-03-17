import java.util.Scanner;

public class InventoryAp {
    public static void main(String[] args) {
        Inventory<Item> inventory = new Inventory<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("=== Aplikasi Inventaris ===");
        do {
            System.out.println("Pilih perintah: ");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tampilkan Item");
            System.out.println("3. Cari Item");
            System.out.println("4. Keluar");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Masukkan nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan jumlah item: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    inventory.addItem(new Item(name, quantity));
                    break;
                case "2":
                    System.out.println("Daftar Item:");
                    inventory.displayItems();
                    break;
                case "3":
                    System.out.print("Masukkan nama item yang dicari: ");
                    String searchName = scanner.nextLine();
                    Item foundItem = inventory.findItemByName(searchName);
                    if (foundItem != null) {
                        System.out.println("Item ditemukan: " + foundItem);
                    } else {
                        System.out.println("Item tidak ditemukan.");
                    }
                    break;
                case "4":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Perintah tidak valid.");
            }
        } while (!command.equals("4"));

        scanner.close();
    }
}