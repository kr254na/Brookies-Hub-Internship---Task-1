import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = null;
        FileWriter fw=null;
        try
        {
            br = new BufferedReader(new FileReader("./Products.csv"));
            fw = new FileWriter("./NewProducts.csv", false);
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(exception);
            System.exit(0);
        }
        System.out.println("Products\tPrice");
        String line;
        br.readLine(); // skip header if exists
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            double price=0;
            try
            {
                price = Double.parseDouble(arr[1]);
            }
            catch(NumberFormatException exception)
            {
                System.out.println(exception);
                System.exit(0);
            }
                if(price<0)
                    throw new InvalidProductDataException("Price cannot be less than 0");
                System.out.println(arr[0] + "\tRs " + price);
                if (price > 1000) {
                    fw.write(arr[0] + "," + arr[1] + "\n");
                }
        }
        try {
            System.out.println("Success");
        }
        finally
        {
        fw.close();
        br.close();
    }
    }
}
