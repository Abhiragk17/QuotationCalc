import java.io.*;

public class FarmHouse {
    int tier_type;
    double size;
    String city_name;

    FarmHouse(int type,double s,String name){
        this.tier_type = type;
        this.size = s;
        this.city_name = name.toLowerCase();
    }

    double BmachCost;
    double LabourCost;
    double MaterialCost;
    double FinishingCost;
    double ResourcesCost;
    boolean bool;
    void fhcost() throws IOException{
        if(size >700){
            try{
                throw new PlotSizeNotFound();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        File f = new File("C:\\Users\\ABHIRAG\\OneDrive\\Desktop\\OOPS TA\\teir2.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String str;
        while((str=br.readLine())!=null){
            String[] ssplit = str.split("  ");
            String name = ssplit[0];
            if(name.equals(city_name)){
                BmachCost = Double.parseDouble(ssplit[1]);
                LabourCost = Double.parseDouble(ssplit[2]);
                MaterialCost = Double.parseDouble(ssplit[3]);
                FinishingCost = Double.parseDouble(ssplit[4]);
                ResourcesCost = Double.parseDouble(ssplit[5]);
                bool =true;
                break;
            }

            if(!bool){
                try{
                    throw new CityNotFoundException();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        br.close();

    }

    void calculateEstimate(){
        
        System.out.println("City : " + city_name + "    Type : Tier " + tier_type + "    Area : " + size + " sq. feet");
        System.out.println("Estimate : ");
        System.out.println("==================================");
        System.out.println("Basic Machinery Cost : Rs. " + BmachCost*size);
        System.out.println("Labour Cost : Rs. " + LabourCost*size);
        System.out.println("Material Cost : Rs. " + MaterialCost*size);
        System.out.println("Finishing Cost : Rs. " + FinishingCost*size);
        System.out.println("Resources Cost : Rs. " + ResourcesCost*size);
    }
}
