import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException(String message) {
        super(message);
    }
}

class CustomIOException extends Exception {
    public CustomIOException(String message) {
        super(message);
    }
}

public class DistanceDemo {

    //method that reads distances from a file, converts them, and writes results to another file.
    public static void distancesFromFile(String inputFile, String outputFile) throws CustomFileNotFoundException, CustomIOException {

        // Try catch to ensure proper closing of files. This handles the reading from
        // the input file and writing to the output file.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;

            // Read lines until the end of the file is reached.
            while ((line = reader.readLine()) != null) {
                try {
                    double miles = Double.parseDouble(line); //Convert string read from file to double miles.
                    double kilometers = DistanceConverter.milesToKilometers(miles); //// Convert miles to kilometers using the DistanceConverter class.
                    writer.write(kilometers + "\n"); // Write converted distance to the output file with newline character.
                } catch (NegativeDistanceException e) { //// Catch custom exception for negative distances.
                    System.err.println("negative distance found.: " + e.getMessage());
                }
            }
        } catch (java.io.FileNotFoundException e) { // Catch custom exception for when file is not found.
            throw new CustomFileNotFoundException("Input file not found");
        } catch (IOException e) { // Catch custom exception for when there is an input output error when reading or writing file.
            throw new CustomIOException("Error: IO error");
        }
    }
}



