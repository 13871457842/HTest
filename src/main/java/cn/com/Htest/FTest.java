package cn.com.Htest;

import org.junit.Test;

import java.util.*;

public class FTest {

    public static Map digitsMap = null;

    /**
     * define an array
     */
    public static void initDigitsMap() {
        digitsMap = new HashMap<String, List<String>>();
        digitsMap.put("0", Arrays.asList(""));
        digitsMap.put("1", Arrays.asList(""));
        digitsMap.put("2", Arrays.asList("A", "B", "C"));
        digitsMap.put("3", Arrays.asList("D", "E", "F"));
        digitsMap.put("4", Arrays.asList("G", "H", "I"));
        digitsMap.put("5", Arrays.asList("J", "K", "L"));
        digitsMap.put("6", Arrays.asList("M", "N", "O"));
        digitsMap.put("7", Arrays.asList("P", "Q", "R", "S"));
        digitsMap.put("8", Arrays.asList("T", "U", "V"));
        digitsMap.put("9", Arrays.asList("W", "X", "Y", "Z"));
    }

    /**
     * numbers are converted to letters
     */
    public static void digitsToLetters() {
        Scanner sc = new Scanner(System.in);
        String digits = "";
        while (true) {
            System.out.println("please enter the number 0-99:");
            digits = sc.next();
            break;
        }
        //define output copy
        StringBuilder arrInput = new StringBuilder("Input:arr[] ={");
        String[] arrStr = digits.split("");
        List<String[]> dataList = new ArrayList<String[]>();

        for (int i = 0; i < arrStr.length; i++) {
            arrInput.append(arrStr[i]);
            if (i < arrStr.length - 1) {
                arrInput.append(",");
            }
            //take an array of letters for each number and store it in the collection
            List<String> lettersList = (List<String>) digitsMap.get(arrStr[i]);
            if (lettersList.size() > 0) {
                String[] letterArr = (String[]) lettersList.toArray();
                dataList.add(letterArr);
            }
        }
        arrInput.append("}");

        //recursively implements most group permutations and returns the final permutation set
        List<String[]> resultList = convertToLetters(dataList, 0, null);
        //print input
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        //print and output permutation and combination results
        for (int i = 0; i < resultList.size(); i++) {
            String[] letterArr = resultList.get(i);
            System.out.print(" ");
            for (String s : letterArr) {
                System.out.print(s);
            }
        }
    }

    /**
     * recursion method
     * @param dataList alphanumeric array
     * @param index
     * @param resultList
     * @return
     */
    private static List<String[]> convertToLetters(List<String[]> dataList, int index, List<String[]> resultList) {
        //end of the recursive
        if (index == dataList.size()) {
            return resultList;
        }

        List<String[]> resultList0 = new ArrayList<String[]>();
        //the default of the first column array is to add as many permutations as the number of letters
        if (index == 0) {
            String[] dataArr = dataList.get(0);
            for (String s : dataArr) {
                resultList0.add(new String[]{s});
            }
        } else {
            String[] dataArr = dataList.get(index);
            for (String[] dataArr0 : resultList) {
                for (String s : dataArr) {
                    //array capacity
                    String[] dataArrCopy = new String[dataArr0.length + 1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length - 1] = s;
                    //reassemble returns the result set
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return convertToLetters(dataList, ++index, resultList0);
    }
}
