import java.io.FileWriter;
import java.util.ArrayList;


public class ReportGenerator {



    public void generate(
            ArrayList<Vulnerability> vulnerabilities
    ){


        try{


            FileWriter writer =
                    new FileWriter(
                            "Vulnerability_Report.txt"
                    );


            writer.write(
                    "SYSTEM VULNERABILITY REPORT\n\n"
            );


            for(
                    Vulnerability v : vulnerabilities
            ){


                writer.write(
                        v.toString()
                );


            }


            writer.close();


            System.out.println(
                    "Report Generated Successfully"
            );


        }


        catch(Exception e){


            System.out.println(
                    "Report Error"
            );


        }


    }


}