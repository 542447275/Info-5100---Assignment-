package DessertPackage;

public class Checkout {

    private DessertItem[] dessertItems;
    private int numberOfItems;
    private final int WIDTH = 30;

    public Checkout(){
        dessertItems = new DessertItem[100];
        numberOfItems = 0;
    }

    public int numberOfItems(){
        return numberOfItems;
    }

    public void enterItem(DessertItem item){
        this.dessertItems[numberOfItems++] = item;
    }
    public void clear(){
        for(int i = 0; i < numberOfItems; i++)
            this.dessertItems[i] = null;
        numberOfItems = 0;
    }

    public int totalCost(){
        int sum = 0;
        for(int i = 0; i < numberOfItems; i++)
            sum += dessertItems[i].getCost();
        return sum;
    }

    public int totalTax(){
        return (int)Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100.0);
    }

    @Override
    public String toString(){
        StringBuilder receipt = new StringBuilder();


        receipt.append("    " + DessertShoppe.STORE_NAME + "\n");
        receipt.append("    " + "--------------------" + "\n");

        for(int i = 0; i < numberOfItems; i++){
            StringBuilder item = new StringBuilder(dessertItems[i].getName());

            String priceOfItem = DessertShoppe.cents2dollarsAndCents(dessertItems[i].getCost());
            if (priceOfItem.length() > DessertShoppe.COST_WIDTH)
                priceOfItem = priceOfItem.substring(0, DessertShoppe.COST_WIDTH);

            if (dessertItems[i] instanceof IceCream) {
                while(item.length() < WIDTH - priceOfItem.length()){
                    item.append(" ");
                }
                receipt.append(item).append(priceOfItem).append("\n");
            }
            else if (dessertItems[i] instanceof Sundae) {

                receipt.append(((Sundae) dessertItems[i]).getTopping()).append(" DessertPackage.Sundae with\n");

                while(item.length() < WIDTH - priceOfItem.length()){
                    item.append(" ");
                }
                receipt.append(item).append(priceOfItem).append("\n");
            }
            else if (dessertItems[i] instanceof Candy){
                receipt.append(((Candy) dessertItems[i]).getWeight()).append(" lbs @ ").append(DessertShoppe.cents2dollarsAndCents(((Candy) dessertItems[i]).getPricePerPound())).append(" /lb.\n");

                while(item.length() < WIDTH - priceOfItem.length()){
                    item.append(" ");
                }
                receipt.append(item).append(priceOfItem).append("\n");
            }
            else {
                receipt.append(((Cookie) dessertItems[i]).getNumber()).append(" @ ").append(DessertShoppe.cents2dollarsAndCents(((Cookie) dessertItems[i]).getPricePerDozen())).append(" /dz\n");

                while(item.length() < WIDTH - priceOfItem.length()){
                    item.append(" ");
                }
                receipt.append(item).append(priceOfItem).append("\n");
            }
        }

        StringBuilder line = new StringBuilder("\nTax");
        String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());
        while(line.length() <= WIDTH - tax.length())
            line.append(" ");
        receipt.append(line).append(tax);

        String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());
        line = new StringBuilder("\nTotal Cost");
        while(line.length() <= WIDTH - totalCost.length())
            line.append(" ");
        receipt.append(line).append(totalCost);

        return receipt.toString();
    }
}
