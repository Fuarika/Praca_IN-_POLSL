package pl.oktawia.sporys.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.repository.ResultRepository;
import pl.oktawia.sporys.service.ResultService;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;

@Slf4j
public class Arithmetic {

    private Double tmpMy;
    private Double tmpMx;
    private String solution;

   @Autowired
   ResultRepository resultRepository;

    private Integer absoluteValue(Integer arg1C, Integer arg2C) {
        Integer tmp = arg1C - arg2C;

        if (tmp >= 0) {
            return tmp;
        } else
            return -tmp;
    }
    public Result addOrSubFloatingPoint(Types type, Double arg1M, Integer arg1C,
                                        Double arg2M, Integer arg2C, Integer p ) {

        //Double dArg1M = Double.valueOf(arg1M);
        //Double dArg2M = Double.valueOf(arg2M);

        Integer tmpC;
        tmpC = arg1C - arg2C;

        if (tmpC == 0) {
            tmpMx = arg1M; //dArg1M;
            tmpMy = arg2M; //dArg2M;
        } else if (tmpC > 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M; //dArg1M;
            tmpMy = arg2M*(pow(p,tmp));     //dArg2M;
        } else if (tmpC < 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);

            tmpMx =  arg1M *(pow(p,tmp));     //dArg1M;
            tmpMy = arg2M; //dArg2M;
        }

        if(type.compareTo(Types.ADDITION) == 0){
            Double mZ = tmpMx + tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);

                solution = test1(mZ,cZ);



        }else if (type.compareTo(Types.SUBTRATION) == 0){
            Double mZ = tmpMx - tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);
            //if (mZ > 0 || mZ <= 0.01){
              //  solution = getMantissaAndExponent(solution);
           // }

        }



       // String normalized = getMantissaAndExponent(solution);


        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("z aretmic");
        result.setStep_2("baka3");
        result.setStep_3("baka3");
        result.setStep_4("baka3");

        return result;
    }


    public Result multiplicatonFlatingPoint(Double arg1M, Integer arg1C, Double arg2M, Integer arg2C, Integer p) {

        //Double dArg1M = Double.valueOf(arg1M);
        //Double dArg2M = Double.valueOf(arg2M);

        Double mZ = arg1M * arg2M;
        Integer cZ = arg1C + arg2C;
        solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);

        //if (mZ > 0 || mZ <= 0.01){
        //    solution = getMantissaAndExponent(solution);
       // }
        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("mnoz");
        result.setStep_2("b");
        result.setStep_3("c");
        result.setStep_4("b");

        return result;
    }

    public Result divisionFlatingPoint(Double arg1M, Integer arg1C, Double arg2M, Integer arg2C, Integer p) {

        //Double dArg1M = Double.valueOf(arg1M);
        //Double dArg2M = Double.valueOf(arg2M);

        Double mZ = arg1M / arg2M;
        Integer cZ = arg1C - arg2C;
        solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);
        //if (mZ > 0 || mZ <= 0.01){
        //    solution = getMantissaAndExponent(solution);
       // }
        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("dziel");
        result.setStep_2("b");
        result.setStep_3("c");
        result.setStep_4("b");
        return result;
    }

    /* public String normalize(String s) {
        String tmpS = s.substring(1,4);
        char[] tmpCh = tmpS.toCharArray();
        Integer count = 0;
        for(int i = 0; i < tmpCh.length; i++){
            if (tmpCh[i] == '.') {
                if (tmpCh[i] == '0') {
                    count++;
                }
            }
        }


        return null;
    } */

    String getMantissaAndExponent(String str) {
        String solution = null;
        try {
            double testedFloatNumber = Double.parseDouble(str);
            int expo = Math.getExponent(testedFloatNumber);
            int numericSystemBase = 10;
            double mantissa = testedFloatNumber / Math.pow(numericSystemBase,expo);
            double exponentForFloatingPointNumber = Double.sum(Double.valueOf(String.valueOf(mantissa).split("E")[1]), expo);

            solution =  String.valueOf(mantissa).split("E")[0] + "E" + exponentForFloatingPointNumber;
            return solution;
        } catch (NumberFormatException e) {
            log.error("Cannot parse to double " + str, e);
        }
        return solution;
    }

    public String test1(Double mantissa, Integer exponant) {
        //double mantissa = 10.6342d;
        String string = Double.toString(mantissa);
        String[] stringVal = string.split("\\.");

        if (stringVal[0].length() > 1) {
            if(stringVal[0].matches("-")){
                String[] decimal = stringVal[1].split("");
                String newDecimal = decimal[1];
                String rest = "";
                int exp = 0;
                for (int i =1; i < decimal.length; i++) {
                    rest += decimal[i];
                    exp = i;
                }
                exponant += exp;
                String normalizedDown = "-" + newDecimal + "." + rest + stringVal[1] + " x 10 ^" + exponant;
                return normalizedDown;
            }else {
                String[] decimal = stringVal[0].split("");
                String newDecimal = decimal[0];
                String rest = "";
                int exp = 0;
                for (int i = 1; i < decimal.length; i++) {
                    rest += decimal[i];
                    exp = i;
                }
                exponant += exp;
                String normalizedDown = newDecimal + "." + rest + stringVal[1] + " * 10 ^" + exponant;
                return normalizedDown;
                //System.out.println(normalizedDown);
            }
        } else {return mantissa + "x10^" + exponant;}

    }
}
