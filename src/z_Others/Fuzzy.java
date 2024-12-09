package z_Others;

import train6.prompt5.AppleReplacer;

public class Fuzzy {
    record NoOfEmptyCellR(double LOW, double MEDIUM, double HIGH){}
    record AlphaBetaTimeR(double SHORT, double MODERATE, double LONG){}
    record AlgoTypeR(double ALPHA_BETA, double GENETIC){}
    enum AlgoType{ GA,AB }

    private NoOfEmptyCellR checkNoOfEmptyCell(double val, final int N){
        double leftOne, leftTwo, midOne, midTwo;
        leftOne = 0.3 * N;
        leftTwo = 0.4 * N;
        midOne = 0.6 * N;
        midTwo = 0.7 * N;

        if(val <= leftOne){
            return new NoOfEmptyCellR(1,0,0);
        }

        if(val < leftTwo){ // 0.3 to 0.4
            double low = (leftTwo - val) / (leftTwo - leftOne);
            double medium = (val - leftOne)/(leftTwo - leftOne);

            return new NoOfEmptyCellR(low,medium,0);
        }

        if(val <= midOne){
            return new NoOfEmptyCellR(0,1,0);
        }

        if(val < midTwo){ // .6 to .7
            double medium = (midTwo - val) / (midTwo - midOne);
            double high = (val - midOne) / (midTwo - midOne);
            return new NoOfEmptyCellR(0,medium,high);
        }

        return new NoOfEmptyCellR(0,0,1);
    }

    private AlphaBetaTimeR checkAlphaBetaTime(double val){
        double leftOne, leftTwo, midOne, midTwo;
        leftOne = 5;
        leftTwo = 7;
        midOne = 15;
        midTwo = 20;


        if(val <= leftOne){
            return new AlphaBetaTimeR(1,0,0);
        }

        if(val < leftTwo){ // 0.3 to 0.4
            double low = (leftTwo - val) / (leftTwo - leftOne);
            double medium = (val - leftOne)/(leftTwo - leftOne);

            return new AlphaBetaTimeR(low,medium,0);
        }

        if(val <= midOne){
            return new AlphaBetaTimeR(0,1,0);
        }

        if(val < midTwo){ // .6 to .7
            double medium = (midTwo - val) / (midTwo - midOne);
            double high = (val - midOne) / (midTwo - midOne);
            return new AlphaBetaTimeR(0,medium,high);
        }

        return new AlphaBetaTimeR(0,0,1);
    }

    private AlgoTypeR infer(NoOfEmptyCellR cell, AlphaBetaTimeR time){
//        double ga1 = cell.HIGH;
//        double ga2 = Math.max( Math.min( cell.LOW, cell.MEDIUM), time.LONG );
//
//        double ga = (ga1 + ga2) / 2;
//        double ab = Math.max( Math.min( cell.LOW, cell.MEDIUM), Math.min( time.SHORT, time.MODERATE) );
//
//        return new AlgoTypeR(ab, ga);

        // GPT
        double ga1 = cell.HIGH;
        double ga2 = Math.min(Math.max(cell.LOW, cell.MEDIUM), time.LONG);

        double ab = Math.min(Math.max(cell.LOW, cell.MEDIUM), Math.max(time.SHORT, time.MODERATE));
        double ga = Math.max(ga1, ga2);

        return new AlgoTypeR(ab, ga);
    }

    private double deFuzzyFy(double AB, double GA) {
        // 0 - 40: AB, 40 - 60: AB or GA, 60 - 100: GA

        double numerator = 0;
        double denominator = 0;

        for(int i=0; i<=100; i++){
            double valToUse = (i <= 40) ? AB :
                    (i >= 60) ? GA :
                            Math.max(AB,GA);

            numerator += i * valToUse;
            denominator += valToUse;
        }

        return numerator / denominator;
    }

    private AlgoType calcValue(double percent){
        if(percent < 50) return AlgoType.AB;
        return AlgoType.GA;
    }

    private AlgoType predictAlgo(int N_N, int emptyCells, int timeTaken){
        final NoOfEmptyCellR cell = checkNoOfEmptyCell(emptyCells, N_N);
        final AlphaBetaTimeR time = checkAlphaBetaTime(timeTaken);

        final AlgoTypeR algoType = infer(cell,time);

        double percent = deFuzzyFy(algoType.ALPHA_BETA, algoType.GENETIC);
        return calcValue(percent);
    }

    private void start(){
        final int N_N = 25;
        final int emptyCells = 10;
        final int timeTaken = 5;

        final AlgoType type = predictAlgo(N_N, emptyCells, timeTaken);
        System.out.println(type);
    }

    public static void main(String[] args) {
        new Fuzzy().start();
    }

}
