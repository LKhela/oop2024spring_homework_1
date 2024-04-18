package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Rental Company that manages scooters.
 */
public class RentalCompany {

    private int uid = 0;
    private List<Scooter> scooters = new ArrayList<>();

    public RentalCompany() {
        // Initialize three scooters with availability set to true
        addScooter(new Scooter("Scooter_1"));
        addScooter(new Scooter("Scooter_2"));
        addScooter(new Scooter("Scooter_3"));
    }

    /**
     * Adds a scooter to the rental company.
     *
     * @param scooter The scooter to add.
     */
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooter.setAvailable(true); // Mark the added scooter as available
        scooters.add(scooter);
    }

    /**
     * Removes a scooter from the rental company based on its ID.
     *
     * @param id The ID of the scooter to remove.
     * @return True if the scooter was removed successfully, false otherwise.
     */
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter based on its ID.
     *
     * @param id The ID of the scoter to rent.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                if (scooter.isAvailable()) {
                    scooter.rent();
                } else {
                    System.out.println("Scooter " + id + " is not available for rent.");
                }
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " not found.");
    }

    /**
     * Returns a rented scooter to the rental company.
     *
     * @param id The ID of the scooter to return.
     */
    public void returnScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.returnScooter();
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " not found.");
    }

    /**
     * Displays all scooters owned by the rental company.
     */
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }

    /**
     * Gets a scooter by its ID.
     *
     * @param id The ID of the scooter to get.
     * @return The scooter with the specified ID, or null if not found.
     */
    public Scooter getScooterById(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                return scooter;
            }
        }
        return null; // Scooter not found
    }
}
