import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Flat {

    int tier;
    String city;
    double size;
    String HouseType;

    Flat(int tier, String city, double size, String HouseType){
        this.tier = tier;
        this.city = city.toLowerCase();
        this.size = size;
        this.HouseType = HouseType;
    }

    double MachCost;
    double LabourCost;
    double MaterialCost;
    double FinishingCost;
    double ResourcesCost;
    double SpecialCosts;
    boolean jon = false;

    void getRate() throws FileNotFoundException,IOException{

        File f = new File("/Users/abhople/Desktop/QuotationCalcOOP/tier1.txt" + tier + ".txt");
        // File h = new File("/Users/abhople/Desktop/QuotationCalcOOP/HouseType.txt" + tier + ".txt");
        // BufferedReader in1 = new BufferedReader(new FileReader(h));
        BufferedReader in = new BufferedReader(new FileReader(f));
        String str;


        while ((str = in.readLine())!=null){
            String[] ssplit = str.split("    ");
            String name = ssplit[0];
            if (name.equals(city)) {
                MachCost = Double.parseDouble(ssplit[1]);
                LabourCost = Double.parseDouble(ssplit[2]);
                MaterialCost = Double.parseDouble(ssplit[3]);
                FinishingCost = Double.parseDouble(ssplit[4]);
                ResourcesCost = Double.parseDouble(ssplit[5]);
                jon = true;
                break;
            }

        }
        in.close();
    }

    void calculateQuotation(){
        if (jon==false){
            System.out.println("Quotation cannot be calculated");
            return;
        }
        System.out.println("City: " + city + "   Type: " + tier + "   Area: " + size + " sq. feet");
        System.out.println("Estimate: ");
        System.out.println("------------------------------");
        System.out.println("Basic Machinery cost: Rs. " + MachCost*size);
        System.out.println("labour cost: Rs. " + LabourCost*size);
        System.out.println("Material cost: Rs. " + MaterialCost*size);
        System.out.println("Finishing cost: Rs. " + FinishingCost*size);
        System.out.println("Resources cost: Rs. " + ResourcesCost*size);

    }

}
