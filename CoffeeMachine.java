import java.util.Scanner;

public class CoffeeMachine {
    
    private int water;
    private int milk;
    private int coffee;
    private int disposableCups;
    private int money;
    
    public CoffeeMachine() {
        this(400, 540,  120, 9, 550);
    }
    
    public CoffeeMachine(int water, int milk, int coffee, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.disposableCups = disposableCups;
        this.money = money;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        
        boolean flag = true;
        
        while(flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch(scanner.nextLine()) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    coffeeMachine.buy(scanner.nextLine());
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    int water = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milk = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int coffee = Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int disposableCups = Integer.parseInt(scanner.nextLine());
                    coffeeMachine.fill(water, milk, coffee, disposableCups);
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.has();
                    break;
                case "exit":
                    flag = false;
                    break;
                default :
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
    
    public boolean calculationCup(int needWater, int needMilk, int needCoffee) {
        return disposableCups > 0 && water >= needWater && milk >= needMilk && coffee >= needCoffee;
    }
    
    public void buy(String command) {
        switch(command) {
            case "1":
                if (calculationCup(250, 0, 16)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffee -= 16;
                    disposableCups--;
                    money += 4;
                } else {
                    System.out.println("I can't make a cup of coffee!");
                }
                break;
            case "2":
                if (calculationCup(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    disposableCups--;
                    money += 7;
                } else {
                    System.out.println("I can't make a cup of coffee!");
                }
                break;
            case "3":
                if (calculationCup(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    disposableCups--;
                    money += 6;
                } else {
                    System.out.println("I can't make a cup of coffee!");
                }
                break;
            case "back":
                break;
            default :
                System.out.println("Unknown command");
                break;
        }
    }
    
    public void fill(int water, int milk, int coffee, int disposableCups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.disposableCups += disposableCups;
    }
    
    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    
    public void has() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
