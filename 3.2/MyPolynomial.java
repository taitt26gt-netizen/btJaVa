public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] == 0.0 && coeffs.length > 1) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(coeffs[i] >= 0 ? " + " : " - ");
                sb.append(Math.abs(coeffs[i]));
            } else {
                sb.append(coeffs[i]);
            }

            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }
        return sb.toString();
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial another) {
        int maxLen = Math.max(this.coeffs.length, another.coeffs.length);
        double[] runCoeffs = new double[maxLen];
        for (int i = 0; i < maxLen; i++) {
            double c1 = (i < this.coeffs.length) ? this.coeffs[i] : 0.0;
            double c2 = (i < another.coeffs.length) ? another.coeffs[i] : 0.0;
            runCoeffs[i] = c1 + c2;
        }
        return new MyPolynomial(runCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial another) {
        int newLen = this.coeffs.length + another.coeffs.length - 1;
        double[] runCoeffs = new double[newLen];
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < another.coeffs.length; j++) {
                runCoeffs[i + j] += this.coeffs[i] * another.coeffs[j];
            }
        }
        return new MyPolynomial(runCoeffs);
    }
}