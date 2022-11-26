import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bunglow {

    String type;
    String city;
    double size;

    Bunglow(String type, String city,double size){
        this.type = type;
        this.city = city.toLowerCase();
        this.size = size;
    }

    double BmachCost;
    double LabourCost;
    double MaterialCost;
    double FinishingCost;
    double ResourcesCost;
    double SmachCost;
    boolean b = false;

    void getCost() throws FileNotFoundException, IOException {
        if(size<500){
            try{
                throw new PlotSizeNotFound();
            }
            catch(PlotSizeNotFound e){
                System.out.println(e);
            }
            return;
        }

            File f = new File("C:\\Users\\ayush\\OneDrive\\Desktop\\new\\Tier" + type + ".txt");

            BufferedReader in = new BufferedReader(new FileReader(f));
            String str;


            while((str=in.readLine())!=null){
                String[] ssplit = str.split("    ");
                String name = ssplit[0];
                if(name.equals(city)){
                    BmachCost = Double.parseDouble(ssplit[1]);
                    LabourCost = Double.parseDouble(ssplit[2]);
                    MaterialCost = Double.parseDouble(ssplit[3]);
                    FinishingCost = Double.parseDouble(ssplit[4]);
                    ResourcesCost = Double.parseDouble(ssplit[5]);
                    SmachCost = Double.parseDouble(ssplit[6]);
                    b = true;
                    break;
                }
            }

            if(b==false){
                System.out.println("Sorry! Currently we do not provide our services in " + city);
            }
            in.close();

    }

    void calculateEstimate(){
        if(b==false){
            System.out.println("Sorry! we are unable to calculate the estimate");
            return;
        }
        System.out.println("City : " + city + "    Type : Tier " + type + "    Area : " + size + " sq. feet");
        System.out.println("Estimate : ");
        System.out.println("==================================");
        System.out.println("Basic Machinery Cost : Rs. " + BmachCost*size);
        System.out.println("Labour Cost : Rs. " + LabourCost*size);
        System.out.println("Material Cost : Rs. " + MaterialCost*size);
        System.out.println("Finishing Cost : Rs. " + FinishingCost*size);
        System.out.println("Resources Cost : Rs. " + ResourcesCost*size);
        System.out.println("Special Machinery Cost : Rs. " + SmachCost*size);
    }
    

}
