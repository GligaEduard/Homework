import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {
        System.out.println("Hello ! Select one from the below options: ");
        System.out.println(" 1. Add a car \n 2. List all car from inventory \n 3. Rent a car \n 4. Return a car \n 5. Close the program");
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        List<Car> inventory = new ArrayList<>();
        List<Car> availableCars = new ArrayList<>();
        List<Car> rentedCars = new ArrayList<>();
        while (running) {
            int userChoice = keyboard.nextInt();
            if (userChoice == 1) {
                System.out.println("Please enter:\n 1. The id of the car you want to rent \n 2. Car make \n 3. Car model \n 4. Rental price \n 5. Year \n 6. Mileage \n 7. Fuel type");
                Car car = new Car(keyboard.nextInt(), keyboard.next(), keyboard.next(), keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(), keyboard.next());

                inventory.add(car);


                availableCars.add(car);

            }
            if (userChoice == 2) {
                for (int carNo = 0; carNo < inventory.size(); carNo++) {
                    System.out.println(inventory.get(carNo));
                }
            }
            if (userChoice == 3) {
                System.out.println("Enter the id of the car you want to rent");
                int carIdToRent = keyboard.nextInt();
                boolean carFoundInInventory = false;
                if (inventory.isEmpty()) {
                    try {
                        throw new Exception("Inventory is empty");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int carNo = 0; carNo < inventory.size(); carNo++) {
                    if (inventory.get(carNo).getId() == carIdToRent) carFoundInInventory = true;
                }
                if (!carFoundInInventory) try {
                    throw new Exception("The car is not found in the inventory");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                else {
                    if (availableCars.isEmpty()) try {
                        throw new Exception("No Available cars");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    boolean carFoundInAvailable = false;
                    for (int carNo = 0; carNo < availableCars.size(); carNo++) {
                        if (availableCars.get(carNo).getId() == carIdToRent) {
                            rentedCars.add(availableCars.get(carNo));
                            availableCars.remove(carNo);
                            carFoundInAvailable = true;
                            System.out.println("Car is successfully rented.");
                        }
                    }
                    if (!carFoundInAvailable) try {
                        throw new Exception("The car is already rented");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (userChoice == 4) {
                System.out.println("Please enter the id of the rented car you want to return.");
                int carIdToReturn = keyboard.nextInt();
                boolean carFoundInRentedCars = false;
                for (int carNo = 0; carNo < rentedCars.size(); carNo++) {
                    if (rentedCars.get(carNo).getId() == carIdToReturn) {
                        availableCars.add(rentedCars.get(carNo));
                        rentedCars.remove(carNo);
                        carFoundInRentedCars = true;
                        System.out.println("The rented car was successfully returned.");
                    }
                }

                if (!carFoundInRentedCars) try {
                    throw new Exception("The car is not found in rented cars.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            if (userChoice >=6 ) {
                System.out.println("Available options are: \n 1. Add a car \n 2. List all car from inventory \n 3. Rent a car \n 4. Return a car \n 5. Close the program.");
            }
            if(userChoice == 5){
                running = false;
            }
        }

    }
}