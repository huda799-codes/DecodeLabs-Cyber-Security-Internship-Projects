import java.util.ArrayList;


public class FirewallScanner {


    public ArrayList<Vulnerability> checkFirewall(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        String os =
                System.getProperty("os.name");


        System.out.println(
                "Checking Firewall..."
        );


        if(os.contains("Windows")){


            list.add(
                    new Vulnerability(
                            "Firewall Verification",
                            "Windows firewall status should be checked",
                            RiskLevel.HIGH,
                            "Enable firewall protection"
                    )
            );


        }


        return list;

    }

}
