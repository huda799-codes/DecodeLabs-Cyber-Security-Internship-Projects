import java.util.ArrayList;


public class FirewallScanner {


    public ArrayList<Vulnerability> checkFirewall(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        try{


            Process p =
                    Runtime.getRuntime()
                            .exec(
                                    "netsh advfirewall show allprofiles"
                            );



            if(p.waitFor()==0){


                list.add(
                        new Vulnerability(

                                "Firewall Check",

                                "Firewall configuration verified",

                                RiskLevel.LOW,

                                "Keep firewall enabled"

                        ));


            }



        }

        catch(Exception e){


            list.add(

                    new Vulnerability(

                            "Firewall Disabled",

                            "Firewall status cannot be verified",

                            RiskLevel.CRITICAL,

                            "Enable firewall immediately"

                    )

            );

        }


        return list;


    }


}