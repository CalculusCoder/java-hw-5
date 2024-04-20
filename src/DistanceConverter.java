public class DistanceConverter {

    public static double milesToKilometers(double miles) throws NegativeDistanceException {
        if (miles < 0) {
            throw new NegativeDistanceException("Distance cannot be negative.");
        }
        return miles * 1.60934;
    }

    public static double kilometersToMiles(double kilometers) throws NegativeDistanceException {
        if (kilometers < 0) {
            throw new NegativeDistanceException("Distance cannot be negative.");
        }
        return kilometers / 1.60934;
    }

}
