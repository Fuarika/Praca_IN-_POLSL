package pl.oktawia.sporys.algorithm;

import pl.oktawia.sporys.model.Exercise;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;


public class Arithmetic {
    private Double tmpMy;
    private Double tmpMx;
    public Double arg1M;
    public Double arg2M;
    public Double arg1C;
    public Double arg2C;
    public Double arg1P;
    public Double arg2P;

    public void splitArg(Exercise ex) {
        String arg1;
        String arg2;


       // arg1M = Double.valueOf(arg1.substring(1,4));
       // arg1C = Double.valueOf(arg1.substring(6,7));
        //arg1P = Double.valueOf(arg1.substring(9,11));

        //arg2M = Double.valueOf(arg2.substring(1,4));
        //arg2C = Double.valueOf(arg2.substring(6,7));
        //arg2P = Double.valueOf(arg2.substring(9,11));
    }

    private Double absoluteValue(Double arg1C, Double arg2C) {
        Double tmp = arg1C - arg2C;

        if (tmp >= 0) {
            return tmp;
        } else
            return -tmp;
    }
    public String additionalFloatingPoint( Exercise ex ) {
        splitArg(ex);
        Double tmpC;
        tmpC = arg1C - arg2C;
        if (tmpC == 0) {
            tmpMx = arg1M;
            tmpMy = arg2M;
        } else if (tmpC > 0) {
            Double tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M;
            tmpMy = arg2M*(pow(arg2P,tmp));
        } else if (tmpC < 0) {
            Double tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M*(pow(arg2P,tmp));
            tmpMy = arg2M;
        }
        Double mZ = tmpMx + tmpMy;
        Double cZ = max(arg1C,arg2C);
        String z = String.valueOf(mZ) + "x" + String.valueOf(arg1P) + "^"
                + String.valueOf(cZ);
        return z;
    }

    public String odejmowanieFloatingPoint( Exercise ex ) {
        splitArg(ex);
        Double tmpC;
        tmpC = arg1C - arg2C;
        if (tmpC == 0) {
            tmpMx = arg1M;
            tmpMy = arg2M;
        } else if (tmpC > 0) {
            Double tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M;
            tmpMy = arg2M*(pow(arg2P,tmp));
        } else if (tmpC < 0) {
            Double tmp = -absoluteValue(arg1C,arg2C);
            tmpMx = arg1M*(pow(arg2P,tmp));
            tmpMy = arg2M;
        }
        Double mZ = tmpMx - tmpMy;
        Double cZ = max(arg1C,arg2C);
        String z = String.valueOf(mZ) + "x" + String.valueOf(arg1P) + "^"
                + String.valueOf(cZ);
        return z;
    }

    public String mnozenieFlatingPoint(Exercise ex) {
        splitArg(ex);
        Double mZ = arg1M * arg2M;
        Double cZ = arg1C + arg2C;
        String z = String.valueOf(mZ) + "x" + String.valueOf(arg1P) + "^"
                + String.valueOf(cZ);
        return z;
    }

    public String dzielenieFlatingPoint(Exercise ex) {
        splitArg(ex);
        Double mZ = arg1M / arg2M;
        Double cZ = arg1C - arg2C;
        String z = String.valueOf(mZ) + "x" + String.valueOf(arg1P) + "^"
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
