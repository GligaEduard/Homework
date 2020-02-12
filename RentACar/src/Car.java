public class Car {
    private int id;
    private String make;
    private String model;
    private int rentalPrice;
    private int year;
    private int mileage;
    private String fuelType;

   public Car(int id, String make, String model, int rentalPrice, int year, int mileage, String fuelType ){
        this.id = id;
        this.make = make;
        this.model = model;
        this.rentalPrice = rentalPrice;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                "\n, make='" + make + '\'' +
                "\n, model='" + model + '\'' +
                "\n, rentalPrice=" + rentalPrice +
                "\n, year=" + year +
                "\n, mileage=" + mileage +
                "\n, fuelType='" + fuelType + '\'' +
                '}';
    }
}
