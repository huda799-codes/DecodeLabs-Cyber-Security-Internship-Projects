import java.util.ArrayList;


public class UpdateScanner {


    public ArrayList<Vulnerability> checkUpdates(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        list.add(

                new Vulnerability(

                        "Software Updates",

                        "Missing updates can expose known vulnerabilities",

                        RiskLevel.HIGH,

                        "Install latest operating system and software patches"

                )

        );


        return list;

    }

}