package main.items;

/**
 * @author Jules
 * Contains the list of accepted car brands
 */
public enum CarBrand {
    MERCEDES ("Mercedes"),
    TOYOTA ("Toyota"),
    NISSAN ("Nissan"),
    AUDI ("Audi"),
    BENTLEY("Bentley");

    private final String carBrand;

    private CarBrand(String s) {
        carBrand = s;
    }


    public boolean equalsName(String brand) {
        return carBrand.equals(brand);
    }

    public static boolean containsBrand(String brand) {
        for (CarBrand cb : CarBrand.values()) {
            if(cb.equalsName(brand))
                return true;
        }
        return false;
    }

    public String toString() {
        return this.carBrand;
    }
}