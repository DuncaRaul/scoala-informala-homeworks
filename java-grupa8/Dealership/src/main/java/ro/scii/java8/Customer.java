package ro.scii.java8;


import java.io.*;
import java.util.*;

/**
 * @author x-RauL-x
 * This class represents the available actions of the customer towards the dealership.
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String customerId;
    private float budget;
    private int option;
    private GreenBonusProgram gb = new GreenBonusProgram();
    private Dealership checkStock = new Dealership();
    private Dealership requestGBP = new Dealership();
    private Scanner s = new Scanner(System.in);
    private int checkProgram;

    public Customer(String firstName,String lastName, String customerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
    }



    /**
     * This method displays the vehicle list to the customer.
     * When this method is over, it calls the sortVehicles() method.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void viewAllVehiclesList() throws IOException, ClassNotFoundException {

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> vehicleView = eVReader.readVehicles();
        eVReader.close();

        for (ElectricVehicle v : vehicleView) {
            System.out.println(v.getManufacturer() + "\n Model: " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                    "\t Battery: " + v.getBatteryCapacity() + " kWh" + "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                    "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
        }
        sortVehicles();
    }


    /**
     * This method allows the customer to filter the vehicle list based on Price, Motor Power, and Range.
     * When this method is over, it calls the filterVehicles() method.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void sortVehicles() throws IOException, ClassNotFoundException {

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> vehicleView = eVReader.readVehicles();

        eVReader.close();

        PriceComparator priceComparator = new PriceComparator();
        RangeComparator rangeComparator = new RangeComparator();
        MotorPowerComparator motorPowerComparator = new MotorPowerComparator();

        System.out.println("Do you want the vehicle list to be sorted by an attribute? y/n ");
        String verifySort = s.next();
        if (verifySort.equals("y")) {

            System.out.println("Please input the sorting attribute: price = p, range = r, motor power = m");
            String verifyAttribute = s.next();
            switch (verifyAttribute) {

                case "p":
                    Collections.sort(vehicleView, priceComparator);
                    break;

                case "m":
                    Collections.sort(vehicleView, motorPowerComparator);
                    break;

                case "r":
                    Collections.sort(vehicleView, rangeComparator);
                    break;

                default:
                    //If the user types anything else except "p", "m", or "r", an exception will be thrown.
                    throw new IllegalArgumentException("Only \"p\", \"m\", or \"r\" options can be used.");

            }
            filterVehicles();

        } else if (verifySort.equals("n")) {
            filterVehicles();
        } else {
            //If the user types anything else except "y" or "n", an exception will be thrown.
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
    }

    /**
     * This method allows the customer to filter out the vehicles which are not in stock or the ones which do not have fast charging.
     * When this method is over, if the customer wants to buy a car, it calls the chooseVehicles() method.
     * If the customer does not want to buy a car, the program is closed.
     * If the customer types anything else except "y" or "n" as answers, an exception will be thrown.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void filterVehicles() throws IOException, ClassNotFoundException {

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> vehicleView = eVReader.readVehicles();
        eVReader.close();


        System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
        String verifyFilterPS = s.next();


        if (verifyFilterPS.equals("y")) {
            System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
            String verifyFilterPSF = s.next();
            if (verifyFilterPSF.equals("y")) {
                //This happens when the customer wants to use both filters.
                for (ElectricVehicle v : getVehiclesInStockList(getFastChargingList(vehicleView))) {
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
                }
            } else if (verifyFilterPSF.equals("n")) {
                //This happens when the customer wants to only use the stock filter.
                for (ElectricVehicle v : getVehiclesInStockList(vehicleView)) {
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
                }
            } else {
                throw new IllegalArgumentException("Only y or n options can be used.");
            }
        } else if (verifyFilterPS.equals("n")) {
            System.out.println("Do you want to exclude the vehicles that do not have fast charging? y/n");
            String verifyFilterPF = s.next();
            if (verifyFilterPF.equals("y")) {
                //This happens when the customer wants to only use the fast-charging filter.
                for (ElectricVehicle v : getFastChargingList(vehicleView))
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
            } else if (verifyFilterPF.equals("n")) {
                //This happens when the customer wants to use no filters.
                for (ElectricVehicle v : vehicleView) {
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
                }
            } else {
                throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
            }
        } else {
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }

        System.out.println("Do you want to buy a car? y/n");
        String buy = s.next();
        if (buy.equals("y")) {
            chooseVehicle();
        } else if (buy.equals("n")) {
            System.out.println("Thank you for visiting!");
        } else {
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }

    }

    /**
     * This class prints the available vehicles for purchase, excluding the ones that are not in stock since they cannot be purchased.
     * From this point forward, the List which the program will use will not be the ViewList, but the Database list, generated from the same ElectricVehicles.csv file.
     * This is necessary since we do not want this list sorted and filtered instead we want all the vehicles available for purchase to be displayed to maximize the Dealership's
     * chance for a vehicle to be sold.
     * When this method is over, if the customer wishes to buy a vehicle the useGreenBonusProgram() method will be called, which handles the exceptional case in which the customer
     * tries to purchase a vehicle which is not in stock
     * or a vehicle which does not exist.
     * If the customer does not want to buy a vehicle, the program will close.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void chooseVehicle() throws IOException, ClassNotFoundException {


        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> database = eVReader.readVehicles();
        eVReader.close();

        System.out.println("Which car do you want to buy?");

        int j = 0;
        //This algorithm iterates through the vehicles which are available for purchase and displays them.
        for (ElectricVehicle v : database) {
            if ((v.getStockNr()) > 0) {
                System.out.println(j + " " + v.getManufacturer() + " " + v.getVehicleModel());
            }
            j++;
        }
        useGreenBonusProgram();
    }

    /**
     * This method asks the client a series of questions about the Green Bonus Program (if he wants to use it or not, and so on) and also does not allow the customer to
     * purchase a vehicle if it exceeds his budget with or without the Green Bonus Program funding, with the Green Bonus Program funding if the car is not new, and also if the vehicle is not in stock.
     *
     * @return Returns the checkProgram integer as 0, 1, or 2 depending on the answers of the customer, on his budget, on the Green Bonus Program, and also on the stock number of the desired vehicle.
     * The integer's value will determine the outcome if the next method called, purchaseVehicle().
     * @throws IllegalArgumentException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int useGreenBonusProgram() throws IllegalArgumentException, IOException, ClassNotFoundException {

        option = s.nextInt();

        if (option > 8) {
            //If the customer types anything else except the index of the displayed vehicles as answers, an exception will be thrown.
            throw new IllegalArgumentException("You can only choose between 0 and 8.");
        }

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> database = eVReader.readVehicles();
        eVReader.close();

        System.out.println("Do you want to use the Green Bonus Program? y/n");
        String gbp = s.next();

        if (gbp.equals("y")) {

            if (gb.checkFunds()) {
                if (checkStock.checkIfCarIsInStock(database.get(option))) {
                    if ((budget + 10000 >= database.get(option).getPrice())) {
                        if ((requestGBP.checkIfDealershipCanGrantFunds(database.get(option)))) {
                            checkProgram = 1;
                            purchaseVehicle();
                            return checkProgram;
                        } else {
                            checkProgram = 0;
                            purchaseVehicle();
                            return checkProgram;
                        }
                    } else {
                        System.out.println("The vehicle's price exceeds your budget!");
                        checkProgram = 2;
                        purchaseVehicle();
                        return checkProgram;
                    }
                } else {
                    System.out.println("The vehicle is not in stock!");
                    checkProgram = 2;
                    purchaseVehicle();
                    return checkProgram;
                }

            } else if (!gb.checkFunds()) {
                System.out.println("We are sorry, but the Green Bonus Program doesn't have enough funds at this moment");
                checkProgram = 0;
                purchaseVehicle();
                return checkProgram;
            }
        } else if (gbp.equals("n")) {
            checkProgram = 0;
            purchaseVehicle();
            return checkProgram;
        } else {
            //If the customer types anything else except "y" or "n" as answers, an exception will be thrown.
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
        return checkProgram = 3;
    }

    /**
     * This method receives the checkProgram integer returned by the previous method (useGreenBonusProgram()), and it determines if the purchase can be made.
     *  This method allows the purchase to be made with the Green Bonus Program or without it.
     *  If none of the purchases are possible, this algorithm calls the anotherCar() method.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void purchaseVehicle() throws IOException, ClassNotFoundException {

        Dealership checkStock = new Dealership();

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> database = eVReader.readVehicles();
        eVReader.close();


        if (checkProgram == 1) {
            gb.getFunds();
            successfulPurchase(database);
            gb.subtractFunds();
        } else if (checkProgram == 0) {
            System.out.println("Do you want to buy the car at full price? y/n");
            purchaseFullPrice(checkStock, database);
        } else if (checkProgram == 2) {
            anotherCar();

        }

    }

    /**
     * This method is used if the vehicle can only be bought without the Green Bonus Program funding. It doesn't allow the customer to buy the vehicle if it is out of stock
     * or if the customer's budget is not sufficient.
     * If the purchase is not possible, this algorithm calls the anotherCar() method.
     * If the customer types anything else except "y" or "n" as answers, an exception will be thrown.
     *
     * @param checkStock = Object on which the checkIfCarIsInStock() method is called, which doesn't allow the vehicle to be purchased if it's stock number is 0.
     * @param vehicleList = The vehicle list received, in our case, the database list.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void purchaseFullPrice(Dealership checkStock, List<ElectricVehicle> vehicleList) throws IOException, ClassNotFoundException {
        String fullPrice = s.next();
        if (fullPrice.equals("y")) {
            if (checkStock.checkIfCarIsInStock(vehicleList.get(option))) {
                if (budget >= vehicleList.get(option).getPrice()) {
                    successfulPurchase(vehicleList);
                } else {
                    System.out.println("This vehicle's price exceeds your budget!");
                    anotherCar();
                }
            } else {
                System.out.println("The vehicle is not in stock");
                anotherCar();
            }
        } else if (fullPrice.equals("n")) {
            anotherCar();
        } else {
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
    }

    /**
     * This method is used when the vehicle is successfully purchased, whether the purchase was made with funding from the Green Bonus Program or not.
     * This method also overwrites the ElectricVehicles.csv file so that the the stocks of the vehicles are updated if a successful purchase is made.
     * @param database = The list received to be overwritten in order for it to be updated.
     * @throws IOException
     */
    public void successfulPurchase(List<ElectricVehicle> database) throws IOException {
        System.out.println("Congratulations on your new car, please come to the office to complete the payment and paperwork.");
        subtractStockByOne(database, option);
        EVWriter evWriter = new EVWriter(new BufferedWriter(new FileWriter("ElectricVehicles.csv")));
        for (ElectricVehicle v : database) {
            evWriter.writeVehicles(v);
        }
        evWriter.flush();
        evWriter.close();
    }

    /**
     * This method is called whenever a purchase was unsuccessful.
     * If the user wants to try buying a different vehicle, the chooseVehicle() method will be called. Otherwise, the program will be terminated.
     * If the customer types anything else except "y" or "n" as answers, an exception will be thrown.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void anotherCar() throws IOException, ClassNotFoundException {
        System.out.println("Do you want to buy another car? y/n");
        String another = s.next();
        if (another.equals("y")) {
            chooseVehicle();
        } else if (another.equals("n")) {
            System.out.println("Thank you for visiting!");
        } else {
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
    }

    /**
     * This method subtracts the stock of a vehicle when it has been purchased by a customer.
     * @param electricVehicleList = The list that contains the vehicles.
     * @param option = The vehicle the customer chose to purchase.
     */
    public void subtractStockByOne(List<ElectricVehicle> electricVehicleList, int option) {
        int x = electricVehicleList.get(option).getStockNr();
        electricVehicleList.get(option).setStockNr(x - 1);
    }

    /**
     * This method filters the vehicles list so it doesn't contain non fast-charging vehicles.
     * @param fastChargingList = The vehicle list.
     * @return The filtered list, without fast-charging vehicles.
     */
    public List<ElectricVehicle> getFastChargingList(List<ElectricVehicle> fastChargingList) {
        List<ElectricVehicle> tempList = new ArrayList<>();
        for (ElectricVehicle v : fastChargingList) {
            if (v.isHasFastCharging()) {
                tempList.add(v);
            }
        }
        return tempList;
    }

    /**
     * This method filters the vehicles list so it doesn't contain vehicles that are not in stock.
     * @param stockList = The vehicle list.
     * @return = The filtered list, without vehicles which are not in stock.
     */
    public List<ElectricVehicle> getVehiclesInStockList(List<ElectricVehicle> stockList) {
        List<ElectricVehicle> tempList = new ArrayList<>();
        for (ElectricVehicle v : stockList) {
            if (v.getStockNr() > 0) {
                tempList.add(v);
            }
        }
        return tempList;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}


