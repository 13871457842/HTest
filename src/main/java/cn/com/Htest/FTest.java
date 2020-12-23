package cn.com.Htest;

import java.util.*;

public class FTest {

    public static Map digitsMap = null;

    /**
     * 定义数字字母集合
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
     * 数字转化为字母
     */
    public static void digitsToLetters() {
        Scanner sc = new Scanner(System.in);
        String digits = "";
        while (true) {
            System.out.println("请输入0-99的数字:");
            digits = sc.next();
            break;
        }
        //定义输出文案
        StringBuilder arrInput = new StringBuilder("Input:arr[] ={");
        String[] arrStr = digits.split("");
        List<String[]> dataList = new ArrayList<String[]>();

        for (int i = 0; i < arrStr.length; i++) {
            arrInput.append(arrStr[i]);
            if (i < arrStr.length - 1) {
                arrInput.append(",");
            }
            //拿到每个数字对应的字母数组并存入集合
            List<String> lettersList = (List<String>) digitsMap.get(arrStr[i]);
            if (lettersList.size() > 0) {
                String[] letterArr = (String[]) lettersList.toArray();
                dataList.add(letterArr);
            }
        }
        arrInput.append("}");

        //递归实现多数组排列组合，并返回最终的排列集合
        List<String[]> resultList = convertToLetters(dataList, 0, null);
        //打印输入内容
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        //打印输出排列组合结果
        for (int i = 0; i < resultList.size(); i++) {
            String[] letterArr = resultList.get(i);
            System.out.print(" ");
            for (String s : letterArr) {
                System.out.print(s);
            }
        }
    }

    /**
     * 递归方法
     * @param dataList 字母数组集合
     * @param index
     * @param resultList
     * @return
     */
    private static List<String[]> convertToLetters(List<String[]> dataList, int index, List<String[]> resultList) {
        //结束递归
        if (index == dataList.size()) {
            return resultList;
        }

        List<String[]> resultList0 = new ArrayList<String[]>();
        //第一列数组默认有多少个字母就添加多少个排列数据
        if (index == 0) {
            String[] dataArr = dataList.get(0);
            for (String s : dataArr) {
                resultList0.add(new String[]{s});
            }
        } else {
            String[] dataArr = dataList.get(index);
            for (String[] dataArr0 : resultList) {
                for (String s : dataArr) {
                    //数组扩容
                    String[] dataArrCopy = new String[dataArr0.length + 1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length - 1] = s;
                    //重新组装返回结果集
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return convertToLetters(dataList, ++index, resultList0);
    }

    public static void main(String[] args) {
        //定义数字_字母集合
        initDigitsMap();
        //数字转化字母
        digitsToLetters();
    }
}
