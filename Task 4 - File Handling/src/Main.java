import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader("./Products.csv"));
             FileWriter fw = new FileWriter("./NewProducts.csv", true)) {

            System.out.println("Products\tPrice");

            String line;
            br.readLine(); // skip header if exists
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                double price = Double.parseDouble(arr[1]);
                System.out.println(arr[0] + "\tRs " + price);

                if (price > 1000) {
                    fw.write(arr[0] + "," + arr[1] + "\n");
                }
            }
            System.out.println("Success");
        }
    }
}
