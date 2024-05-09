package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CypherIO {
    /**
     * Reads the contents of a file and returns it as a string.
     *
     * @param  fileName  the name of the file to be read
     * @return           the contents of the file as a string
     */
    public String readFile(String fileName) {
        StringBuilder build = new StringBuilder("");
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                build.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }
      return build.toString();
    }
    /**
     * Writes the given data to a file specified by the given path.
     *
     * @param  path  the path to the file where the data will be written
     * @param  data  the data to be written to the file
     */
    public void writeFile(String path, String data) {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getLocalizedMessage());
        }
    }
}
