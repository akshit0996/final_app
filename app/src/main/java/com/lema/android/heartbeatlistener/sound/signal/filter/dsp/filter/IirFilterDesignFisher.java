package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.Complex;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.PolynomialUtils;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.PolynomialUtils.RationalFraction;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util.ArrayUtils;

public class IirFilterDesignFisher {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterCharacteristicsType;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$IirFilterDesignFisher$SToZMappingMethod;

    private static class PolesAndZeros {
        public Complex[] poles;
        public Complex[] zeros;

        private PolesAndZeros() {
        }
    }

    private enum SToZMappingMethod {
        bilinearTransform,
        matchedZTransform
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterCharacteristicsType() {
        int[] iArr = $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterCharacteristicsType;
        if (iArr == null) {
            iArr = new int[FilterCharacteristicsType.values().length];
            try {
                iArr[FilterCharacteristicsType.bessel.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FilterCharacteristicsType.butterworth.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FilterCharacteristicsType.chebyshev.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterCharacteristicsType = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType() {
        int[] iArr = $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType;
        if (iArr == null) {
            iArr = new int[FilterPassType.values().length];
            try {
                iArr[FilterPassType.bandpass.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FilterPassType.bandstop.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FilterPassType.highpass.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FilterPassType.lowpass.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$IirFilterDesignFisher$SToZMappingMethod() {
        int[] iArr = $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$IirFilterDesignFisher$SToZMappingMethod;
        if (iArr == null) {
            iArr = new int[SToZMappingMethod.values().length];
            try {
                iArr[SToZMappingMethod.bilinearTransform.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SToZMappingMethod.matchedZTransform.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$IirFilterDesignFisher$SToZMappingMethod = iArr;
        }
        return iArr;
    }

    private IirFilterDesignFisher() {
    }

    private static Complex[] getPoles(FilterCharacteristicsType filterCharacteristicsType, int filterOrder, double ripple) {
        Complex[] poles;
        int i;
        switch ($SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterCharacteristicsType()[filterCharacteristicsType.ordinal()]) {
            case 1:
                poles = new Complex[filterOrder];
                for (i = 0; i < filterOrder; i++) {
                    poles[i] = Complex.expj(((((((double) filterOrder) / 2.0d) + 0.5d) + ((double) i)) * 3.141592653589793d) / ((double) filterOrder));
                }
                return poles;
            case 2:
                if (ripple >= 0.0d) {
                    throw new IllegalArgumentException("Chebyshev ripple must be negative.");
                }
                poles = getPoles(FilterCharacteristicsType.butterworth, filterOrder, 0.0d);
                double y = asinh(1.0d / Math.sqrt(Math.pow(10.0d, (-ripple) / 10.0d) - 1.0d)) / ((double) filterOrder);
                if (y <= 0.0d) {
                    throw new AssertionError();
                }
                double sinhY = Math.sinh(y);
                double coshY = Math.cosh(y);
                for (i = 0; i < filterOrder; i++) {
                    poles[i] = new Complex(poles[i].re() * sinhY, poles[i].im() * coshY);
                }
                return poles;
            case 3:
                return BesselFilterDesign.computePoles(filterOrder);
            default:
                throw new UnsupportedOperationException("Filter characteristics type " + filterCharacteristicsType + " not yet implemented.");
        }
    }

    private static PolesAndZeros normalize(Complex[] poles, FilterPassType filterPassType, double fcf1, double fcf2, boolean preWarp) {
        int n = poles.length;
        boolean fcf2IsRelevant = filterPassType == FilterPassType.bandpass || filterPassType == FilterPassType.bandstop;
        if (fcf1 <= 0.0d || fcf1 >= 0.5d) {
            throw new IllegalArgumentException("Invalid fcf1.");
        } else if (!fcf2IsRelevant || (fcf2 > 0.0d && fcf2 < 0.5d)) {
            double fcf1Warped = Math.tan(3.141592653589793d * fcf1) / 3.141592653589793d;
            double fcf2Warped = fcf2IsRelevant ? Math.tan(3.141592653589793d * fcf2) / 3.141592653589793d : 0.0d;
            if (!preWarp) {
                fcf1Warped = fcf1;
            }
            double w1 = 6.283185307179586d * fcf1Warped;
            if (!preWarp) {
                fcf2Warped = fcf2;
            }
            double w2 = 6.283185307179586d * fcf2Warped;
            PolesAndZeros sPlane;
            int i;
            double w0;
            double bw;
            Complex hba;
            Complex temp;
            switch ($SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType()[filterPassType.ordinal()]) {
                case 1:
                    sPlane = new PolesAndZeros();
                    sPlane.poles = ArrayUtils.multiply(poles, w1);
                    sPlane.zeros = new Complex[0];
                    return sPlane;
                case 2:
                    sPlane = new PolesAndZeros();
                    sPlane.poles = new Complex[n];
                    for (i = 0; i < n; i++) {
                        sPlane.poles[i] = Complex.div(w1, poles[i]);
                    }
                    sPlane.zeros = ArrayUtils.zeros(n);
                    return sPlane;
                case 3:
                    w0 = Math.sqrt(w1 * w2);
                    bw = w2 - w1;
                    sPlane = new PolesAndZeros();
                    sPlane.poles = new Complex[(n * 2)];
                    for (i = 0; i < n; i++) {
                        hba = poles[i].mul(bw / 2.0d);
                        temp = Complex.sub(1.0d, Complex.div(w0, hba).sqr()).sqrt();
                        sPlane.poles[i] = hba.mul(temp.add(1.0d));
                        sPlane.poles[n + i] = hba.mul(Complex.sub(1.0d, temp));
                    }
                    sPlane.zeros = ArrayUtils.zeros(n);
                    return sPlane;
                case 4:
                    w0 = Math.sqrt(w1 * w2);
                    bw = w2 - w1;
                    sPlane = new PolesAndZeros();
                    sPlane.poles = new Complex[(n * 2)];
                    for (i = 0; i < n; i++) {
                        hba = Complex.div(bw / 2.0d, poles[i]);
                        temp = Complex.sub(1.0d, Complex.div(w0, hba).sqr()).sqrt();
                        sPlane.poles[i] = hba.mul(temp.add(1.0d));
                        sPlane.poles[n + i] = hba.mul(Complex.sub(1.0d, temp));
                    }
                    sPlane.zeros = new Complex[(n * 2)];
                    for (i = 0; i < n; i++) {
                        sPlane.zeros[i] = new Complex(0.0d, w0);
                        sPlane.zeros[n + i] = new Complex(0.0d, -w0);
                    }
                    return sPlane;
                default:
                    throw new UnsupportedOperationException("Filter pass type " + filterPassType + " not yet implemented.");
            }
        } else {
            throw new IllegalArgumentException("Invalid fcf2.");
        }
    }

    private static PolesAndZeros MapSPlaneToZPlane(PolesAndZeros sPlane, SToZMappingMethod sToZMappingMethod) {
        PolesAndZeros zPlane;
        switch ($SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$IirFilterDesignFisher$SToZMappingMethod()[sToZMappingMethod.ordinal()]) {
            case 1:
                zPlane = new PolesAndZeros();
                zPlane.poles = doBilinearTransform(sPlane.poles);
                zPlane.zeros = extend(doBilinearTransform(sPlane.zeros), sPlane.poles.length, new Complex(-1.0d));
                return zPlane;
            case 2:
                zPlane = new PolesAndZeros();
                zPlane.poles = doMatchedZTransform(sPlane.poles);
                zPlane.zeros = doMatchedZTransform(sPlane.zeros);
                return zPlane;
            default:
                throw new UnsupportedOperationException("Mapping method " + sToZMappingMethod + " not yet implemented.");
        }
    }

    private static Complex[] doBilinearTransform(Complex[] a) {
        Complex[] a2 = new Complex[a.length];
        for (int i = 0; i < a.length; i++) {
            a2[i] = doBilinearTransform(a[i]);
        }
        return a2;
    }

    private static Complex doBilinearTransform(Complex x) {
        return x.add(2.0d).div(Complex.sub(2.0d, x));
    }

    private static Complex[] extend(Complex[] a, int n, Complex fill) {
        if (a.length >= n) {
            return a;
        }
        int i;
        Complex[] a2 = new Complex[n];
        for (i = 0; i < a.length; i++) {
            a2[i] = a[i];
        }
        for (i = a.length; i < n; i++) {
            a2[i] = fill;
        }
        return a2;
    }

    private static Complex[] doMatchedZTransform(Complex[] a) {
        Complex[] a2 = new Complex[a.length];
        for (int i = 0; i < a.length; i++) {
            a2[i] = a[i].exp();
        }
        return a2;
    }

    private static RationalFraction computeTransferFunction(PolesAndZeros zPlane) {
        Complex[] topCoeffsComplex = PolynomialUtils.expand(zPlane.zeros);
        Complex[] bottomCoeffsComplex = PolynomialUtils.expand(zPlane.poles);
        RationalFraction tf = new RationalFraction();
        tf.top = ArrayUtils.toDouble(topCoeffsComplex, 1.0E-10d);
        tf.bottom = ArrayUtils.toDouble(bottomCoeffsComplex, 1.0E-10d);
        return tf;
    }

    private static double computeGain(RationalFraction tf, FilterPassType filterPassType, double fcf1, double fcf2) {
        switch ($SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType()[filterPassType.ordinal()]) {
            case 1:
                return computeGainAt(tf, Complex.ONE);
            case 2:
                return computeGainAt(tf, new Complex(-1.0d));
            case 3:
                return computeGainAt(tf, Complex.expj(6.283185307179586d * ((fcf1 + fcf2) / 2.0d)));
            case 4:
                return Math.sqrt(computeGainAt(tf, Complex.ONE) * computeGainAt(tf, new Complex(-1.0d)));
            default:
                throw new RuntimeException("Unsupported filter pass type.");
        }
    }

    private static double computeGainAt(RationalFraction tf, Complex w) {
        return PolynomialUtils.evaluate(tf, w).abs();
    }

    private static IirFilterCoefficients computeIirFilterCoefficients(RationalFraction tf) {
        double scale = tf.bottom[0];
        IirFilterCoefficients coeffs = new IirFilterCoefficients();
        coeffs.a = ArrayUtils.divide(tf.bottom, scale);
        coeffs.a[0] = 1.0d;
        coeffs.b = ArrayUtils.divide(tf.top, scale);
        return coeffs;
    }

    public static IirFilterCoefficients design(FilterPassType filterPassType, FilterCharacteristicsType filterCharacteristicsType, int filterOrder, double ripple, double fcf1, double fcf2) {
        Complex[] poles = getPoles(filterCharacteristicsType, filterOrder, ripple);
        SToZMappingMethod sToZMappingMethod = filterCharacteristicsType == FilterCharacteristicsType.bessel ? SToZMappingMethod.matchedZTransform : SToZMappingMethod.bilinearTransform;
        RationalFraction tf = computeTransferFunction(MapSPlaneToZPlane(normalize(poles, filterPassType, fcf1, fcf2, sToZMappingMethod == SToZMappingMethod.bilinearTransform), sToZMappingMethod));
        double gain = computeGain(tf, filterPassType, fcf1, fcf2);
        IirFilterCoefficients coeffs = computeIirFilterCoefficients(tf);
        coeffs.b = ArrayUtils.divide(coeffs.b, gain);
        return coeffs;
    }

    private static double asinh(double x) {
        return Math.log(Math.sqrt(1.0d + (x * x)) + x);
    }
}
