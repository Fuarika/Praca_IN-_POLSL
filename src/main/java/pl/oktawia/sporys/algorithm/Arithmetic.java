package pl.oktawia.sporys.algorithm;

import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;


public class Arithmetic {
    private Double tmpMy;
    private Double tmpMx;
    private String z;


    private Integer absoluteValue(Integer arg1C, Integer arg2C) {
        Integer tmp = arg1C - arg2C;

        if (tmp >= 0) {
            return tmp;
        } else
            return -tmp;
    }
    public Integer addOrSubFloatingPoint( Types type, String arg1M, Integer arg1C,
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
            z = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);

        }else if (type.compareTo(Types.SUBTRATION) == 0){
            Double mZ = tmpMx - tmpMy;
            Integer cZ = max(arg1C,arg2C);
            z = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                    + String.valueOf(cZ);

        }

        ///resultRposity.addResult(); // dodaje i wzraca numer id powstalego rezulta
        return 23; // wzraca numer id resulta?
    }


    public String multiplicatonFlatingPoint(String arg1M, Integer arg1C, String arg2M, Integer arg2C, Integer p) {

        Double dArg1M = Double.valueOf(arg1M);
        Double dArg2M = Double.valueOf(arg2M);

        Double mZ = dArg1M * dArg2M;
        Integer cZ = arg1C + arg2C;
        z = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);
        return z;
    }

    public String divisionFlatingPoint(String arg1M, Integer arg1C, String arg2M, Integer arg2C, Integer p) {

        Double dArg1M = Double.valueOf(arg1M);
        Double dArg2M = Double.valueOf(arg2M);

        Double mZ = dArg1M / dArg2M;
        Integer cZ = arg1C - arg2C;
        z = String.valueOf(mZ) + "x" + String.valueOf(p) + "^"
                + String.valueOf(cZ);
        return z;
    }

    public String normalize(String s) {
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
    }
}
