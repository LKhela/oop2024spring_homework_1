package homeworks.hw1.scooter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a Scooter with unique identifier, model name, battery level,
 * location, and availability status.
 */
public class Scooter {

    private int id;
    private String model;
    private int batteryLevel;
    private double x, y;
    private boolean available;
    private Timer timer; // Timer for automatic return

    /**
     * Constructs a Scooter with the given model name.
     *
     * @param model The model name of the scooter.
     */
    public Scooter(String model) {
        this.model = model;
        this.x = 41.7121106; // Set default X coordinate when scooter is available
        this.y = 44.7489232; // Set default Y coordinate when scooter is available
        this.available = true; // Mark the scooter as available initially
        this.batteryLevel = 100; // Initialize battery level to 100%
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        if (available) {
            // Stop the timer if the scooter becomes available again
            stopTimer();
        }
    }

    /**
     * Rents the scooter, setting its availability to false and updating its
     * location.
     */
    public void rent() {
        if (available) {
            available = false;
            x = 41.775951; // Set X coordinate when scooter is rented
            y = 44.815651; // Set Y coordinate when scooter is rented
            System.out.println("Scooter " + id + " rented.");
            startTimer(); // Start the timer for automatic return
        } else {
            System.out.println("Scooter " + id + " is not available for rent.");
        }
    }

    /**
     * Returns a rented scooter, setting its availability to true and updating its
     * location.
     */
    public void returnScooter() {
        if (!available) {
            available = true;
            x = 41.7121106; // Set default X coordinate when scooter is available again
            y = 44.7489232; // Set default Y coordinate when scooter is available again
            System.out.println("Scooter " + id + " returned.");
            stopTimer(); // Stop the timer for automatic return
        } else {
            System.out.println("Scooter " + id + " is already available.");
        }
    }

    /**
     * Start the timer for automatic return after 1 hour.
     */
    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Scooter " + id + " automatically returned to the University.");
                returnScooter(); // Automatically return the scooter
            }
        }, 3600000); // 1 hour delay in milliseconds
    }

    /**
     * Stop the timer for automatic return.
     */
    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", batteryLevel=" + batteryLevel +
                ", x=" + x +
                ", y=" + y +
                ", available=" + available +
                '}';
    }
}
