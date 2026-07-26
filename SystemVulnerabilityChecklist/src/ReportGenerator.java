import java.io.FileWriter;
import java.util.ArrayList;



public class ReportGenerator {



    public void generate(
            ArrayList<Vulnerability> list
    ){


        try{


            FileWriter file =
                    new FileWriter(
                            "Vulnerability_Report.txt"
                    );



            file.write(
                    "SYSTEM VULNERABILITY ASSESSMENT REPORT\n"
            );

            file.write(
                    "=====================================\n\n"
            );



            for(Vulnerability v:list){


                file.write(
                        v.toString()
                );


            }



            file.close();


            System.out.println(
                    "Report Created"
            );


        }

        catch(Exception e){


            System.out.println(
                    "Error Creating Report"
            );


        }



    }



}