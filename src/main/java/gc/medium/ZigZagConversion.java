//package gc.medium;
//
///**
// * Created by dataanalyze on 2017/10/10.
// */
//public class ZigZagConversion {
//
//
//    public String convert(String s, int numRows) {
//
//        StringBuilder sb = new StringBuilder();
//        int length = s.length();
//
//        assert length>0;
//
//        sb.append(s.charAt(0));
//
//        int firstStep = getFirstStep(numRows);
//
//        for(int i = 0;i<numRows;i++){
//            sb.append(s.charAt(i));
//
//            int step = firstStep-i;
//
//            for(int j = 0, steps = j+ step; j < length && steps<length;steps+= firstStep,j++){
//                sb.append(s.charAt(steps));
//            }
//        }
//
//
//        return null;
//
//    }
//
//
//    private int[] getSteps(int i){
//        int[] steps  = new int[i];
//        if(i<2) return  steps;
//        if(i == 2){
//            steps[0]=2;
//            steps[1] = 2;
//        }else {
//
//            return 2*(i-1);
//        }
//    }
//
//}
