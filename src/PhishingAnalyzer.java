import java.util.Scanner;

public class PhishingAnalyzer {

    static String[] phishingKeywords = {

            "urgent",
            "verify",
            "password",
            "login",
            "click",
            "account",
            "bank",
            "security",
            "confirm",
            "update"

    };



    public static void analyzeEmail(String email) {


        int riskScore = 0;


        String lowerEmail = email.toLowerCase();



        System.out.println("\n===== Analysis Report =====");


        System.out.println("\nDetected Keywords:");

        boolean keywordFound = false;


        for(String word : phishingKeywords) {


            if(lowerEmail.contains(word)) {


                System.out.println("- " + word);

                riskScore += 2;

                keywordFound = true;

            }

        }


        if(!keywordFound){

            System.out.println("No suspicious keywords found");

        }


        System.out.println("\nLink Analysis:");

        if(lowerEmail.contains("http") ||
                lowerEmail.contains("www") ||
                lowerEmail.contains(".com")) {


            System.out.println("- Suspicious link detected");

            riskScore += 3;


        }
        else {


            System.out.println("- No suspicious links found");

        }



        // Password Request Detection

        if(lowerEmail.contains("password")) {


            System.out.println("- User credentials requested");

            riskScore += 3;

        }



        // Risk Level

        System.out.println("\nRisk Score: " + riskScore);



        if(riskScore >= 8) {


            System.out.println("Risk Level: HIGH");

            System.out.println("Result: PHISHING EMAIL");


        }
        else if(riskScore >= 4) {


            System.out.println("Risk Level: MEDIUM");

            System.out.println("Result: SUSPICIOUS EMAIL");


        }
        else {


            System.out.println("Risk Level: LOW");

            System.out.println("Result: SAFE EMAIL");


        }


    }



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);



        System.out.println("===== Phishing Awareness Analyzer =====");



        System.out.println("\nEnter email/message text:");

        String email = scanner.nextLine();



        analyzeEmail(email);



        scanner.close();

    }

}