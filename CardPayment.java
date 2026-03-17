import java.util.Random;
import java.util.Scanner;

class CardPayment implements Payment {

    Scanner sc = new Scanner(System.in);

    public boolean pay(double amount) {

        System.out.print("\nEnter Card Number: ");
        String card = sc.next();

        System.out.print("Enter CVV: ");
        String cvv = sc.next();

        if (card.length() != 16 || cvv.length() != 3) {
            System.out.println("Invalid card details");
            return false;
        }

        for (int i = 0; i < card.length(); i++) {
            if (!Character.isDigit(card.charAt(i))) {
                System.out.println("Invalid card details");
                return false;
            }
        }

        for (int i = 0; i < cvv.length(); i++) {
            if (!Character.isDigit(cvv.charAt(i))) {
                System.out.println("Invalid card details");
                return false;
            }
        }

        int otp = generateOTP();

        System.out.println("Processing card payment...");
        System.out.println("OTP sent successfully: " + otp);

        System.out.print("Enter OTP: ");
        int enteredOtp = sc.nextInt();

        if (enteredOtp != otp) {
            System.out.println("Incorrect OTP. Payment failed");
            return false;
        }

        System.out.println("OTP verified successfully");
        System.out.println("Rs." + amount + " paid successfully");
        return true;
    }

    int generateOTP() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}