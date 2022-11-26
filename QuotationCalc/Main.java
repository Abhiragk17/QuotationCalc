import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File filecheck;
        File f = new File("tier2.txt");
        File f1 = new File("tier3.txt");
        File f2 = new File("tier1.txt");
        File f3 = new File("HouseType.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        BufferedReader in1 = new BufferedReader(new FileReader(f1));
        BufferedReader in2 = new BufferedReader(new FileReader(f2));
        BufferedReader in3 = new BufferedReader(new FileReader(f3));

        String[] arr2;
        String special;
        while ((special=in3.readLine()) != null){
            arr2 = special.split("    ");
        }

        String str;
        String cityName;
        String type;
        int tier;
        boolean check = false;
        boolean typecheck = false;
        boolean tier1 = false,tier2 = false,tier3 = false;
        double plotsize;
        int choice = 1;
        String str1[];
            String str2[];
            String str3[];
            String strfinal1[];
            String strfinal2[];
            String strfinal3[];
        while(choice!=0){
            System.out.println("Enter the city name");
            cityName = sc.next();
            System.out.println("Enter the plot size");
            plotsize = sc.nextDouble();
            System.out.println("Enter the type of house you want to build");
            type = sc.next();
            


            while((str = in.readLine())!=null){
                str1 = str.split("    ");
                if(cityName.equals(str1[0])) {
                    check = true;
                    strfinal1 = str.split("    ");
                    tier2 = true;
                    filecheck = f;
                }

            }
            while((str = in1.readLine())!= null){
                str2 = str.split("    ");
                if(cityName.equals(str2[0])) {
                    check = true;
                    strfinal2 = str.split("    ");
                    tier3 = true;
                    filecheck = f1;
                }
                else{
                    check = false;
                }
            }

            while((str = in2.readLine())!=null){
                str3 = str.split("    ");
                if(cityName.equals(str3[0])) {
                    check = true;
                    strfinal3 = str.split("    ");
                    tier1 = true;
                    filecheck = f2;

                }
                else{
                    check = false;
                }
            }


        }
        if(check == false){
            throw new CityNotFoundException();
        }

        if(type.equals("Duplex") || type.equals("Flat") || type.equals("Bunglow")){
            typecheck = true;
        }
        else{
            throw new HouseException();
        }

        if(tier1){
            tier = 1;
        } else if (tier2) {
            tier = 2;
        } else if (tier3) {
            tier = 3;
        }

        if(typecheck){
            if(type.equals("Duplex")){
                Duplex d = new Duplex(cityName,tier,plotsize,filecheck,str2[0]);
                d.getInfo();
                d.calculatecosts();
                long estimateCost = d.totalEstimate();
                System.out.println("The quotation for Duplex is: " + estimateCost);
            } else if (type.equals("Flat")) {
                Flat fl = new Flat(tier,cityName,plotsize,str2[2]);
            } else if (type.equals("Bunglow")) {
                Bunglow b = new Bunglow(type,cityName,plotsize,str2[1]);
            } else if (type.equals("FarmHouse")) {
                FarmHouse fm = new FarmHouse(1,plotsize,cityName,str2[3]);
            }
        }



    }
}