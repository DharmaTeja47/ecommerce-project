class ConsoleUI {

    static int WIDTH = 148;

    static void printLine() {
        for (int i = 0; i < WIDTH; i++)
            System.out.print("=");
        System.out.println();
    }

    static void printCentered(String text) {
        int padding = (WIDTH - text.length()) / 2;

        for (int i = 0; i < padding; i++)
            System.out.print(" ");

        System.out.println(text);
    }

    

}
