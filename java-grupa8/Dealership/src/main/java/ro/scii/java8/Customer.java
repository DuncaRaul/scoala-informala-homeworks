package ro.scii.java8;


import java.io.*;
import java.util.*;

/**
 * @author x-RauL-x
 * This class represents the available actions of the customer towards the dealership.
 */
public class Customer {

    private String customerName;
    private int customerId;
    private int budget;
    private int option;
    private GreenBonusProgram gb = new GreenBonusProgram();
    private Dealership checkStock = new Dealership();
    private Dealership requestGBP = new Dealership();
    private Scanner s = new Scanner(System.in);
    private int checkProgram;

    public Customer(String customerName, int budget) {
        this.customerName = customerName;
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }


    /**
     * This method displays all the vehicles from a list
     *
     * @param list the list that is displayed
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void viewAllVehiclesList(List<ElectricVehicle> list) throws IOException, ClassNotFoundException {

        for (ElectricVehicle v : list) {
            System.out.println(v.getManufacturer() + "\n Model: " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                    "\t Battery: " + v.getBatteryCapacity() + " kWh" + "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                    "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
        }
        sortVehicles(list);
    }


    /**
     * This method sorts a vehicle list based on parameters chosen by the customer from the keyboard
     *
     * @param list the list that is sorted
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void sortVehicles(List<ElectricVehicle> list) throws IOException, ClassNotFoundException {

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
                    Collections.sort(list, priceComparator);
                    break;

                case "m":
                    Collections.sort(list, motorPowerComparator);
                    break;

                case "r":
                    Collections.sort(list, rangeComparator);
                    break;

                default:
                    throw new IllegalArgumentException("Only \"p\", \"m\", or \"r\" options can be used.");

            }
            filterVehicles(list);

        } else if (verifySort.equals("n")) {
            filterVehicles(list);
        } else {
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
    }

    /**
     * This method filters a vehicle list based on stock number and fast charging
     *
     * @param list the list that is filtered
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void filterVehicles(List<ElectricVehicle> list) throws IOException, ClassNotFoundException {

        List<ElectricVehicle> sortedList = list;

        System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
        String verifyFilterPS = s.next();

        if (verifyFilterPS.equals("y")) {
            System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
            String verifyFilterPSF = s.next();
            if (verifyFilterPSF.equals("y")) {
                for (ElectricVehicle v : getVehiclesInStockList(getFastChargingList(list))) {
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
                }
            } else if (verifyFilterPSF.equals("n")) {
                for (ElectricVehicle v : getVehiclesInStockList(list)) {
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
                for (ElectricVehicle v : getFastChargingList(list))
                    System.out.println(v.getManufacturer() + " " + v.getVehicleModel() + "\n Power: " + v.getMotorPower() + " kW " +
                            "\t Range: " + v.getRange() + " km " + "\t Fast Charging: " + v.isHasFastCharging() +
                            "\t New: " + v.isNew() + "\t Price: " + v.getPrice() + " Euro" + "\t Stock No.: " + v.getStockNr() + "\n");
            } else if (verifyFilterPF.equals("n")) {
                for (ElectricVehicle v : list) {
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
     * This method allows the customer to choose a vehicle to purchase
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void chooseVehicle() throws IOException, ClassNotFoundException {


        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> database = eVReader.readVehicles();
        eVReader.close();

        System.out.println("Which car do you want to buy?");

        int j = 0;

        for (ElectricVehicle v : database) {
            if ((v.getStockNr()) > 0) {
                System.out.println(j + " " + v.getManufacturer() + " " + v.getVehicleModel());
            }
            j++;
        }
        useGreenBonusProgram();
    }


    /**
     * This method allows the customer to use the green bonus program if he wishes.
     *
     * @return The method return an int
     * @throws IllegalArgumentException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int useGreenBonusProgram() throws IllegalArgumentException, IOException, ClassNotFoundException {

        option = s.nextInt();

        if (option > 8) {
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
            throw new IllegalArgumentException("Only \"y\" or \"n\" options can be used.");
        }
        return checkProgram = 3;
    }

    /**
     * This method allows the customer to purchase a vehicle
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
     * This method allows the customer to purchase the vehicle at full price
     *
     * @param checkStock a Dealership type object
     * @param database   a vehicle list
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void purchaseFullPrice(Dealership checkStock, List<ElectricVehicle> database) throws IOException, ClassNotFoundException {
        String fullPrice = s.next();
        if (fullPrice.equals("y")) {
            if (checkStock.checkIfCarIsInStock(database.get(option))) {
                if (budget >= database.get(option).getPrice()) {
                    successfulPurchase(database);
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
     * This method complets the purchase of an electric vehicle
     *
     * @param database the vehicle list
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
     * This method allows the customer to purchase another car from the list
     *
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
     * This method substracts the purchased vehicle from stock
     *
     * @param electricVehicleList the vehicle list
     * @param option              the vehicle that has been purchased by the customer
     */
    public void subtractStockByOne(List<ElectricVehicle> electricVehicleList, int option) {
        int x = electricVehicleList.get(option).getStockNr();
        electricVehicleList.get(option).setStockNr(x - 1);
    }


    /**
     * This method filters the list based on fast charging
     *
     * @param fastChargingList the vehicle list
     * @return the filtered list
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
     * This method filters the list based on the stock number
     *
     * @param stockList the vehicle list
     * @return the filtered list
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
}


