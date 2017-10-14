package ro.scii.java8;

import java.util.*;

/**
 * @author x-RauL-x
 * This class represents the available actions of the customer towards the dealership.
 */
public class Customer {

    /**
     * This method allows the customer to filter and sort the vehicle list.
     * This method also allows the customer to "purchase" a vehicle based on a number of conditions.
     */
    public void carPurchase() {
        Scanner s = new Scanner(System.in);

        //This list represents a view for the customer, based on the dealership's "database" located in the Dealership class.

        List<View> viewVehicleList = new ArrayList<>();

        viewVehicleList.add(new View("BMW", "i3", 40, 50, 230, true, 40000, 5));
        viewVehicleList.add(new View("Hyundai", "Ioniq", 120, 28, 180, false, 36000, 3));
        viewVehicleList.add(new View("Kia", "Soul", 109, 30, 150, false, 33000, 6));
        viewVehicleList.add(new View("Renault", "Zoe", 90, 22, 200, true, 38000, 0));
        viewVehicleList.add(new View("Smart", "ForTwo", 80, 18, 129, true, 32000, 20));
        viewVehicleList.add(new View("Smart", "ForTwoCabrio", 80, 18, 129, true, 34000, 2));
        viewVehicleList.add(new View("Smart", "ForFour", 80, 18, 129, true, 36000, 4));
        viewVehicleList.add(new View("VW", "e-UP", 82, 19, 160, true, 33000, 15));
        viewVehicleList.add(new View("VW", "e-Golf", 115, 36, 201, true, 38500, 0));


        //This series of if and switch statements allow the customer to filter, sort, and buy a vehicle.
        System.out.println("Do you want to sort the vehicle list? y/n ");
        String verifySort = s.next();
        //This part executes if the customer wishes to sort the vehicles.
        if (verifySort.equals("y")) {
            System.out.println("Please input the sorting attribute: price = p, range = r, motor power = m");
            String verifyAttribute = s.next();
            //This switch statement allows the customer to sort the list based on price, range and motor power
            switch (verifyAttribute) {

                //This part executes if the customer wishes to sort the vehicles based on the price.
                case "p":
                    Collections.sort(viewVehicleList, new Comparator<View>() {
                        @Override
                        public int compare(View o1, View o2) {
                            return (int) (o1.getPrice() - o2.getPrice());
                        }
                    });

                    System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
                    String verifyFilterPS = s.next();

                    //This if excludes the vehicles that are not in stock if the customer wishes so.
                    if (verifyFilterPS.equals("y")) {
                        System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPSF = s.next();
                        //This if excludes the vehicles that do not have fast charging if the customer wishes so.
                        if (verifyFilterPSF.equals("y")) {
                            for (View v : getVehiclesInStockList(getFastChargingList(viewVehicleList))) {
                                System.out.println(v);
                            }
                        } else {
                            for (View v : getVehiclesInStockList(viewVehicleList)) {
                                System.out.println(v);
                            }
                        }
                    } else {
                        System.out.println("Do you want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPF = s.next();
                        //This if includes the vehicles that are not in stock and exclude the vehicles that do not have fast charging  if the customer wishes so.
                        if (verifyFilterPF.equals("y")) {
                            for (View v : getFastChargingList(viewVehicleList))
                                System.out.println(v);
                        } else {
                            for (View v : viewVehicleList)
                                System.out.println(v);
                        }
                    }
                    break;

                //This part executes if the customer wishes to sort the vehicles based on the motor power.
                case "m":
                    Collections.sort(viewVehicleList, new Comparator<View>() {
                        @Override
                        public int compare(View o1, View o2) {
                            return (int) (o1.getMotorPower() - o2.getMotorPower());
                        }
                    });
                    System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
                    String verifyFilterPM = s.next();

                    //This if excludes the vehicles that are not in stock if the customer wishes so.
                    if (verifyFilterPM.equals("y")) {
                        System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPMF = s.next();
                        //This if excludes the vehicles that do not have fast charging if the customer wishes so.
                        if (verifyFilterPMF.equals("y")) {
                            for (View v : getVehiclesInStockList(getFastChargingList(viewVehicleList))) {
                                System.out.println(v);
                            }
                        } else {
                            for (View v : getVehiclesInStockList(viewVehicleList)) {
                                System.out.println(v);
                            }
                        }
                    } else {
                        System.out.println("Do you want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPF = s.next();
                        //This if includes the vehicles that are not in stock and exclude the vehicles that do not have fast charging  if the customer wishes so.
                        if (verifyFilterPF.equals("y")) {
                            for (View v : getFastChargingList(viewVehicleList))
                                System.out.println(v);
                        } else {
                            for (View v : viewVehicleList)
                                System.out.println(v);
                        }
                    }
                    break;

                //This part executes if the customer wishes to sort the vehicles based on the vehicle's range.
                case "r":
                    Collections.sort(viewVehicleList, new Comparator<View>() {
                        @Override
                        public int compare(View o1, View o2) {
                            return (o1.getRange() - o2.getRange());
                        }
                    });
                    System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
                    String verifyFilterPR = s.next();

                    //This if excludes the vehicles that are not in stock if the customer wishes so.
                    if (verifyFilterPR.equals("y")) {
                        System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPRF = s.next();
                        //This if excludes the vehicles that do not have fast charging if the customer wishes so.
                        if (verifyFilterPRF.equals("y")) {
                            for (View v : getVehiclesInStockList(getFastChargingList(viewVehicleList))) {
                                System.out.println(v);
                            }
                        } else {
                            for (View v : getVehiclesInStockList(viewVehicleList)) {
                                System.out.println(v);
                            }
                        }
                    } else {
                        System.out.println("Do you want to exclude the vehicles that do not have fast charging? y/n");
                        String verifyFilterPF = s.next();
                        //This if includes the vehicles that are not in stock and exclude the vehicles that do not have fast charging  if the customer wishes so.
                        if (verifyFilterPF.equals("y")) {
                            for (View v : getFastChargingList(viewVehicleList))
                                System.out.println(v);
                        } else {
                            for (View v : viewVehicleList)
                                System.out.println(v);
                        }
                    }
                    break;
            }

        } else {
            System.out.println("Do you want to exclude the vehicles which are not in stock? y/n");
            String verifyFilterPS = s.next();

            //This if excludes the vehicles that are not in stock if the customer wishes so.
            if (verifyFilterPS.equals("y")) {
                System.out.println("Do you also want to exclude the vehicles that do not have fast charging? y/n");
                String verifyFilterPSF = s.next();
                //This if excludes the vehicles that do not have fast charging if the customer wishes so.
                if (verifyFilterPSF.equals("y")) {
                    for (View v : getVehiclesInStockList(getFastChargingList(viewVehicleList))) {
                        System.out.println(v);
                    }
                } else {
                    for (View v : getVehiclesInStockList(viewVehicleList)) {
                        System.out.println(v);
                    }
                }
            } else {
                System.out.println("Do you want to exclude the vehicles that do not have fast charging? y/n");
                String verifyFilterPF = s.next();
                //This if includes the vehicles that are not in stock and exclude the vehicles that do not have fast charging  if the customer wishes so.
                if (verifyFilterPF.equals("y")) {
                    for (View v : getFastChargingList(viewVehicleList))
                        System.out.println(v);
                } else {
                    for (View v : viewVehicleList)
                        System.out.println(v);
                }
            }

        }

        GreenBonusProgram gb = new GreenBonusProgram();

        System.out.println("Do you want to buy a car? y/n");
        String buy = s.next();
        //This if executes if the customer decides to buy a vehicle.
        if (buy.equals("y")) {
            System.out.println("Which car do you want to buy?");
            int j = 0;
            //This for loop displays the vehicle list, hiding the vehicles that are not in stock.
            for (View v : viewVehicleList) {
                if ((v.getStockNr()) > 0) {
                    System.out.println(j + " " + v.getManufacturer() + " " + v.getVehicleModel());
                }
                j++;
            }
            int option = s.nextInt();
            System.out.println("Do you want to use the Green Bonus Program? y/n");
            String gbp = s.next();
            //This if statement executes if the customer decides to use the Green Bonus Program.
            if (gbp.equals("y")) {
                //This if statement executes if the Green Bonus Program has enough funds.
                if (gb.checkBudget()) {
                    System.out.println("Congratulations on your new car, please come to the office to complete the payment and paperwork.");
                    int x = viewVehicleList.get(option).getStockNr();
                    viewVehicleList.get(option).setStockNr(x - 1);
                } else if (!gb.checkBudget()) {
                    System.out.println("We are sorry, but the Green Bonus Program doesn't have enough funds at this moment");
                    System.out.println("Do you want to buy the car at full price? y/n");
                    String fullPrice = s.next();
                    //This if statement executes if the customer decides not to use the Green bonus program.
                    if (fullPrice.equals("y")) {
                        System.out.println("Congratulations on your new car, please come to the office to complete the payment and paperwork.");
                        int x = viewVehicleList.get(option).getStockNr();
                        viewVehicleList.get(option).setStockNr(x - 1);
                    } else {
                        System.out.println("Thank you for visiting!");
                    }
                }

            } else {
                System.out.println("Congratulations on your new car, please come to the office to complete the payment and paperwork.");
                int x = viewVehicleList.get(option).getStockNr();
                viewVehicleList.get(option).setStockNr(x - 1);
            }
        } else {
            System.out.println("Thank you for visiting!");
        }
    }

    private String customerName;
    private int customerId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    /**
     * This method filters the vehicle list based on the fast charging parameter.
     *
     * @param fastChargingList This parameter receives the vehicle list to be sorted.
     * @return The method returns the sorted list based on the fast charging parameter.
     */
    public List<View> getFastChargingList(List<View> fastChargingList) {
        List<View> tempList = new ArrayList<>();
        for (View v : fastChargingList) {
            if (v.isHasFastCharging()) {
                tempList.add(v);
            }
        }
        return tempList;
    }

    /**
     * This method filters the vehicle list based on the stock parameter.
     *
     * @param stockList This parameter receives the vehicle list to be sorted.
     * @return The method returns the sorted list based on the stock parameter.
     */
    public List<View> getVehiclesInStockList(List<View> stockList) {
        List<View> tempList = new ArrayList<>();
        for (View v : stockList) {
            if (v.getStockNr() > 0) {
                tempList.add(v);
            }
        }
        return tempList;
    }
}