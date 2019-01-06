package pl.oktawia.sporys.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.repository.ResultRepository;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;

@Slf4j
public class Arithmetic {

    private Double tmpMy;
    private Double tmpMx;
    private String solution;
    private boolean minus;
    private String normalize = "";
    private String checkExponant;

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

        String solutioMz = "";
        Integer tmpC;
        tmpC = arg1C - arg2C;

        if (tmpC == 0) {
            tmpMx = arg1M;
            tmpMy = arg2M;
            checkExponant = "Ponieważ Cx - Cy = 0 <br>&#160;&#160;&#160;&#160;M'x = Mx = " + tmpMx +
                "<br> &#160;&#160;&#160;&#160;M'y = My = " + tmpMy +"<br>";
        } else if (tmpC > 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M;
            tmpMy = arg2M*(pow(p,tmp));
            checkExponant = "Ponieważ Cx - Cy > 0<br>&#160;&#160;&#160;&#160;M'x = Mx = " + tmpMx +
                    "<br> &#160;&#160;&#160;&#160;M'y = My x 10^(-|Cx-Cy|) = " + tmpMy +"<br>";
        } else if (tmpC < 0) {
            Integer tmp = -absoluteValue(arg1C,arg2C);
            tmpMx =  arg1M *(pow(p,tmp));
            tmpMy = arg2M;
            checkExponant = "Ponieważ Cx - Cy < 0<br>&#160;&#160;&#160;&#160;M'x = Mx x 10^(-|Cx-Cy|) = " + tmpMx +
                    "<br>&#160;&#160;&#160;&#160;M'y = My = " + tmpMy +"<br>";
        }

        if(type.compareTo(Types.ADDITION) == 0){
            Double mZ = tmpMx + tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solutioMz = "Mz = M'x + M'y = " + tmpMx + " + " + tmpMy + " = " + mZ
                    + "<br>Cz = max(Cx,Cy) = max(" + arg1C + "," + arg2C + ") = " + cZ +"<br>";
                solution = normalizeSolution(mZ,cZ);



        }else if (type.compareTo(Types.SUBTRATION) == 0){
            Double mZ = tmpMx - tmpMy;
            Integer cZ = max(arg1C,arg2C);
            solutioMz = "Mz = M'x - M'y = " + tmpMx + " - " + tmpMy + " = " + mZ
                    + "<br>Cz = max(Cx,Cy) = max(" + arg1C + "," + arg2C + ") = " + cZ +"<br>";
            solution = normalizeSolution(mZ,cZ);


        }

        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("Mx = " + arg1M + "&#160; &#160;" + "My = " + arg2M + "<br>" +
            "Cx = " + arg1C + "&#160; &#160;" + "Cy = " + arg2C +"<br>");
        result.setStep_2(checkExponant);
        result.setStep_3(solutioMz);
        result.setStep_4(normalize);

        return result;
    }


    public Result multiplicatonFlatingPoint(Double arg1M, Integer arg1C, Double arg2M, Integer arg2C, Integer p) {


        Double mZ = arg1M * arg2M;
        Integer cZ = arg1C + arg2C;
        solution = normalizeSolution(mZ,cZ);

        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("Mx = " + arg1M + "&#160; &#160;" + "My = " + arg2M + "<br>" +
                "Cx = " + arg1C + "&#160; &#160;" + "Cy = " + arg2C +"<br>");
        result.setStep_2("Mz = Mx * My = " + arg1M + " * " + arg2M + " = " + mZ +
                                     "<br>Cz = " + arg1C + " + " + arg2C + " = " + cZ +"<br>");
        result.setStep_3(normalize);
        result.setStep_4(" ");

        return result;
    }

    public Result divisionFlatingPoint(Double arg1M, Integer arg1C, Double arg2M, Integer arg2C, Integer p) {


        Double mZ = arg1M / arg2M;
        Integer cZ = arg1C - arg2C;
        solution = normalizeSolution(mZ,cZ);

        Result result = new Result();
        result.setAnswer(solution);
        result.setStep_1("Mx = " + arg1M + "&#160; &#160;" + "My = " + arg2M + "<br>" +
                "Cx = " + arg1C + "&#160; &#160;" + "Cy = " + arg2C +"<br>");
        result.setStep_2("Mz = Mx * My = " + arg1M + " / " + arg2M + " = " + mZ +
                "<br>Cz = " + arg1C + " - " + arg2C + " = " + cZ +"<br>");
        result.setStep_3(normalize);
        result.setStep_4(" ");
        return result;
    }


   private Float absoluteValueMantissa (Double mantissa){

        if (mantissa >= 0) {
            minus = false;
            return Float.parseFloat(String.valueOf(mantissa));
        } else {
            minus = true;
            return -Float.parseFloat(String.valueOf(mantissa));
        }
    }

    public String normalizeSolution(Double mantissa, int exponant) {

        Float mantisa = absoluteValueMantissa(mantissa);
        int integerPart = Integer.valueOf(Float.toString(mantisa).split("\\.")[0]);
        int decimalPart = Integer.parseInt(Float.toString(mantisa).split("\\.")[1]);

        if (integerPart >= 1) {
            String string = Float.toString(mantisa);
            String[] stringVal = string.split("\\.");
            int exp = stringVal[0].length();
            BigDecimal newvalue = new BigDecimal(mantisa).movePointLeft(exp);
            double testedFloatNumber = newvalue.round(MathContext.DECIMAL32).doubleValue();
            int newExpo = exp + exponant;
            if (minus == true){
                if (exp == 0){
                    normalize = "";
                } else {
                    normalize = "Sprawdzenie czy wynik potrzeba znormalizować:<br>Mz = |" + mantissa + "| >= 1<br>trzeba przesunąć o " +
                        exp + " w lewo <br>Z = " + (-testedFloatNumber) + "x10^" + newExpo;
                }
                return -testedFloatNumber + "x10^" + newExpo;
            }else {
                if (exp == 0){
                    normalize = "";
                } else {
                    normalize = "Sprawdzenie czy wynik potrzeba znormalizować:<br>Mz = |" + mantissa + "| >= 1<br>trzeba przesunąć " +
                        exp + " w lewo <br>Z = " + testedFloatNumber + "x10^" + newExpo;
                }
                return testedFloatNumber + "x10^" + newExpo;
            }

        } else if (mantisa < 0.1){
            int exp = Integer.toString(decimalPart).length();
            BigDecimal newvalue = new BigDecimal(mantisa).movePointRight(exp);
            double testedFloatNumber = newvalue.round(MathContext.DECIMAL32).doubleValue();
            int newExpo = exponant - exp;

            if (minus == true){
                    normalize = "Sprawdzenie czy wynik potrzeba znormalizować:<br>Mz = |" + mantissa + "| < 0.1<br>trzeba przesunąć o " +
                            exp + " w prawo <br> Z = " + (-testedFloatNumber) + "x10^" + newExpo;

                return -testedFloatNumber + "x10^" + newExpo;
            }else {

                    normalize = "Sprawdzenie czy wynik potrzeba znormalizować:<br>Mz = |" + mantissa + "| < 0.1<br>trzeba przesunąć o " +
                        exp + " w prawo <br>Z = " + testedFloatNumber + "x10^" + newExpo;
                return testedFloatNumber + "x10^" + newExpo;}

        } else {
            BigDecimal newvalue = new BigDecimal(mantissa);
            double testedFloatNumber = newvalue.round(MathContext.DECIMAL32).doubleValue();
            normalize = "Z = " + mantissa + "x10^" + exponant ;
            return testedFloatNumber + "x10^" + exponant;
        }
    }
}
