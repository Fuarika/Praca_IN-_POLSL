package pl.oktawia.sporys.algorithm;

import lombok.extern.slf4j.Slf4j;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.repository.ResultRepository;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;

@Slf4j
public class Arithmetic {

    private Double tmpMy;
    private Double tmpMx;
    private String solution;


    ResultRepository resultRepository;

    private Integer absoluteValue(Integer arg1C, Integer arg2C) {
        Integer tmp = arg1C - arg2C;

        if (tmp >= 0) {
            return tmp;
        } else
            return -tmp;
    }
    public Result addOrSubFloatingPoint(Types type, String arg1M, Integer arg1C,
                                        String arg2M, Integer arg2C, Integer p ) {

        Double dArg1M = Double.valueOf(arg1M);
        Double dArg2M = Double.valueOf(arg2M);

        Integer tmpC;
        tmpC = arg1C - arg2C;

        if (tmpC == 0) {
            tmpMx = dArg1M;
            tmpMy = dArg2M;
        } else if (tmpC > 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = dArg1M;
            tmpMy = dArg2M*(pow(p,tmp));
        } else if (tmpC < 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);

            tmpMx =  dArg1M *(pow(p,tmp));
            tmpMy = dArg2M;
        }

        if(type.compareTo(Types.ADDITION) == 0){
            Double mZ = tmpMx + tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);

        }else if (type.compareTo(Types.SUBTRATION) == 0){
            Double mZ = tmpMx - tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);

        }
        getMantissaAndExponent(solution);
        Result result = new Result(solution);
        result.setStep_1("a");
        result.setStep_1("b");
        result.setStep_3("c");
        result.setStep_4("b");

        result = resultRepository.save(result);
        return result;
    }


    public Result multiplicatonFlatingPoint(String arg1M, Integer arg1C, String arg2M, Integer arg2C, Integer p) {

        Double dArg1M = Double.valueOf(arg1M);
        Double dArg2M = Double.valueOf(arg2M);

        Double mZ = dArg1M * dArg2M;
        Integer cZ = arg1C + arg2C;
        solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);
        getMantissaAndExponent(solution);
        Result result = new Result(solution);
        result.setStep_1("a");
        result.setStep_1("b");
        result.setStep_3("c");
        result.setStep_4("b");

        result = resultRepository.save(result);
        return result;
    }

    public Result divisionFlatingPoint(String arg1M, Integer arg1C, String arg2M, Integer arg2C, Integer p) {

        Double dArg1M = Double.valueOf(arg1M);
        Double dArg2M = Double.valueOf(arg2M);

        Double mZ = dArg1M / dArg2M;
        Integer cZ = arg1C - arg2C;
        solution = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);

        Result result = new Result(solution);
        result.setStep_1("a");
        result.setStep_1("b");
        result.setStep_3("c");
        result.setStep_4("b");
        getMantissaAndExponent(solution);
        result = resultRepository.save(result);
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
}
