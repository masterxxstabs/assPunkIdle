package configs;

public class Data {
    //currencies
    public static double money = 100.00;
    public static double creditScore = money / 0.30;

    //character stuff
    public static String name = "";
    public static String DOB = "";
    public static int age = 18;
    public static double energy = 1.0;

    //time
    public static double Days = 0.000;
    public static int Years = 0;

    //jobs
    public static String job = "";
    public static String foundJob = "";
    public static int wage = 0;
    public static int fastFood = 10, dishWasher = 12, wareHouse = 17, cook = 13, mailMan = 8;
    public static String[] jobs = {" Fast Food Worker", " Dishwasher", " Warehouse Worker", " Cook", " Mailman"};
    public static int[] probabilities = {30, 20, 25, 15, 10};

    //shopping data and taxes
    public static double salesTax = 0.08;

    //save data info
    public static String saveName = "";
    public static String playTime = "";

    //stats
    public static int Strength = 1, Charisma = 1, Endurance = 1, Crafting = 1, Metal_Working = 1, Merchantile = 1;

    //dev settings
    public static boolean findWorkUpdate = true;
    public static boolean workUpdate = false;
    public static boolean quitJobUpdate = false;
    public static boolean isAdmin = false;
}