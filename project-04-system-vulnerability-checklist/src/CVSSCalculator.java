public class CVSSCalculator {


    public static double calculate(
            RiskLevel risk
    ){


        switch(risk){


            case CRITICAL:
                return 9.5;


            case HIGH:
                return 7.5;


            case MEDIUM:
                return 5.0;


            case LOW:
                return 2.5;


            default:
                return 0;


        }

    }


}