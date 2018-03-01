package DessertPackage;

public  class DessertShoppe {
    public final static double TAX_RATE = 6.5;
    public final static String STORE_NAME = "Just a Name";
    public final static int MAX_ITEM_NAME_SIZE = 25;
    public final static int COST_WIDTH = 6;

    public static String cents2dollarsAndCents(int cents) {
        String money = "";

        if (cents < 0) {
            money += "-";
            cents *= -1;
        }

        int dollars = cents / 100;
        cents = cents % 100;

        if (dollars > 0)
            money += dollars;

        money += ".";

        if (cents < 10)
            money += "0";

        money += cents;

        return money;
    }
}
