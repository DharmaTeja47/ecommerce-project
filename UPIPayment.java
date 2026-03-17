import java.util.Random;
import java.util.Scanner;

class UPIPayment implements Payment {

    Scanner sc = new Scanner(System.in);

    public boolean pay(double amount) {

        System.out.print("\nEnter UPI ID: ");
        String upi = sc.next();

        if (upi == null || !upi.contains("@") || upi.startsWith("@") || upi.endsWith("@")) {
            System.out.println("Invalid UPI ID");
            return false;
        }

        int otp = generateOTP();

        System.out.println("Processing payment...");
        System.out.println("OTP sent successfully: " + otp);

        System.out.print("Enter OTP: ");
        int enteredOtp = sc.nextInt();

        if (enteredOtp != otp) {
            System.out.println("Incorrect OTP. Payment failed");
            return false;
        }

        System.out.println("OTP verified successfully");
        System.out.println("Rs." + amount + " paid successfully via UPI");
        return true;
    }

    int generateOTP() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}