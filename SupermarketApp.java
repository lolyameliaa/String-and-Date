import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SupermarketApp {

    // Method untuk login
    public static boolean login(Scanner scanner) {
        String validUsername = "admin";
        String validPassword = "1234";
        String captcha = "xyz123";

        System.out.println("+-----------------------------------------------------+");
        System.out.print("Username : ");
        String username = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        System.out.print("Captcha  : ");
        String inputCaptcha = scanner.nextLine();
        System.out.println("+-----------------------------------------------------+");

        // Validasi login
        if (username.equals(validUsername) && password.equals(validPassword) && inputCaptcha.equals(captcha)) {
            System.out.println("Login berhasil!\n");
            return true;
        } else {
            System.out.println("Login gagal. Silakan coba lagi.\n");
            return false;
        }
    }

    // Method untuk mendapatkan tanggal dan waktu saat ini
    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        return formatter.format(date);
    }

    // Method untuk menghasilkan nomor faktur
    public static String generateFaktur() {
        String prefix = "FTR";
        int randomNum = (int) (Math.random() * 100000);
        return prefix + String.format("%05d", randomNum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di sistem supermarket!");
        boolean isLoggedIn = false;

        // Proses login
        while (!isLoggedIn) {
            isLoggedIn = login(scanner);
        }

        // Informasi supermarket
        String supermarketName = "Supermarket Nurza";
        String cashierName = "Loly Amelia Nurza";

        System.out.println("Selamat Datang di " + supermarketName);
        System.out.println("Tanggal dan Waktu: " + getCurrentDateTime());
        System.out.println("+----------------------------------------------------+");

        // Input detail transaksi
        String faktur = generateFaktur();
        System.out.println("No. Faktur      : " + faktur);

        System.out.print("Kode Barang     : ");
        String kodeBarang = scanner.nextLine();

        System.out.print("Nama Barang     : ");
        String namaBarang = scanner.nextLine();

        System.out.print("Harga Barang    : ");
        double hargaBarang = scanner.nextDouble();

        System.out.print("Jumlah Beli     : ");
        int jumlahBeli = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        double totalHarga = hargaBarang * jumlahBeli;

        System.out.println("+----------------------------------------------------+");
        System.out.printf("TOTAL           : Rp%.2f\n", totalHarga);
        System.out.println("+----------------------------------------------------+");
        System.out.println("Kasir           : " + cashierName);
        System.out.println("+----------------------------------------------------+");

        System.out.println("Terima kasih telah berbelanja di " + supermarketName + "!");
        scanner.close();
    }
}
