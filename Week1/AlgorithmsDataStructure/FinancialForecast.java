package Week1.AlgorithmsDataStructure;

public class FinancialForecast {

    public static double forecast(double initialAmount, double rate, int years) {
        if (years == 0)
            return initialAmount;
        return forecast(initialAmount, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double principal = 10000.0;
        double annualGrowthRate = 0.08;
        int totalYears = 5;

        System.out.println(" Financial Forecast for " + totalYears + " years:");
        for (int i = 0; i <= totalYears; i++) {
            double result = forecast(principal, annualGrowthRate, i);
            System.out.printf("Year %d: ₹%.2f%n", i, result);
        }
    }
}
