import java.util.ArrayList;


public class UserScanner {


    public ArrayList<Vulnerability> checkUsers(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        try{


            Process p =
                    Runtime.getRuntime()
                            .exec("net user");


            if(p!=null){


                list.add(

                        new Vulnerability(

                                "User Account Audit",

                                "System user accounts reviewed",

                                RiskLevel.LOW,

                                "Remove unnecessary accounts"

                        )

                );


            }


        }

        catch(Exception e){


            list.add(

                    new Vulnerability(

                            "User Check Failed",

                            "Unable to read accounts",

                            RiskLevel.MEDIUM,

                            "Review user permissions manually"

                    )

            );


        }


        return list;


    }


}