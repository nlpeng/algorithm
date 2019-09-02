package com.nlpeng.arithmetic;

import java.util.*;

/**
 * @author Ferry NLP
 * @create 2019-09-02
 * @see
 * @since 1.0v
 **/
public class leetcode1_10 {
    public static void main(String[] args) {
        System.out.println("--------------------------Solution0011  BEGIN--------------------------");
        Solution0011 solution0011 = new Solution0011();

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0021  BEGIN--------------------------");

    }
}


/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
class Solution0101{
    public int maxArea(int[] height) {
        int noun= 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int m = (j-i)*Math.min(height[j],height[i]);
                noun =  Math.max(noun,m);
            }
        }
        return noun;
    }
}

class Solution0102{
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}

class Solution0091 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for(int i = 0 , j = s.length()-1;i*2 < s.length() && s.length()<=j*2 ;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else {
                continue;
            }
        }
        return true;
    }
}

/**
 * 使其能将字符串转换成整数
 */
class Solution0081 {
    public int myAtoi(String str) {
        String string = "";

        char[] chars = new char[]{'1','2','3','4','5','6','7','8','9','0'};
        Set set  = new HashSet();
        for (char c:chars) {
            set.add(c);
        }
        boolean b  = true ;
        boolean o = false;
        int c = 0 ;
        for (int j = 0; j < str.length(); j++) {
            if(" ".equals(""+str.charAt(j))&&b) {
                c++;
                continue;
            }else {
                b= false;
            }
            if(c==j){
                if((set.contains(str.charAt(c))&&!("0".equals(""+str.charAt(c))))||"-".equals(""+str.charAt(c))){
                    string +=str.charAt(c);
                    o = true;
                }else if("+".equals(""+str.charAt(c))||"0".equals(""+str.charAt(c))){
                    o = true;
                }else{
                    return 0;
                }
            }
            if(c<j){
                if("-".equals(""+str.charAt(j))||" ".equals(str.charAt(j))||!set.contains(str.charAt(j))){
                    break;
                }else if("0".equals(""+str.charAt(j))&&o){
                    continue;
                }else {
                    string += str.charAt(j);
                    o = false;
                }
            }
        }

        List listmin =new ArrayList();
        List listmax=new ArrayList();
        int INT_MIN =  -2147483648;
        int INT_MAX =  2147483647;
        String MAX =""+INT_MAX;
        String MIN =""+INT_MIN;
        char[] charsmax = MAX.toCharArray();
        for (char cmax: charsmax) {
            listmax.add(cmax);
        }
        char[] charsmin = MAX.toCharArray();
        for (char cmin: charsmin) {
            listmin.add(cmin);
        }
        if(string.length()==1&&!set.contains(string.charAt(0))){
            return 0;
        }else if(string.length()<1){
            return 0;
        }
        if("-".equals(""+string.charAt(0))){
            if(string.length()<11){
                return Integer.parseInt(string);
            }else if(string.length()==11){
                long lll =  Long.parseLong(string);
                if(lll<=INT_MIN){
                    return INT_MIN;
                }else {
                    return Integer.parseInt(string);
                }
            }else {
                return INT_MIN;
            }
        }else {
            if(string.length()<10){
                return Integer.parseInt(string);
            }else if(string.length()==10){
                long lll =  Long.parseLong(string);
                if(lll>=INT_MAX){
                    return INT_MAX;
                }else {
                    return Integer.parseInt(string);
                }
            }else {
                return INT_MAX;
            }
        }
    }
}

class Solution0071 {
    public int reverse(int x) {
        int l = 0;
        int a,b;
        do{ a = x/10;
            b = x%10;
            x=a ;
            l=l*10+b;

        }while(a!=0);
        return l;
    }
}

/**
 *
 */
class Solution0061 {
    public String convert(String s, int numRows) {
        String b = "";
        if(numRows<2){
            return s;
        }
        int group = ((numRows-1)*2);
        int ifzero=s.length()%group;
        int common=s.length()/group;
        for (int i = 0; i < numRows; i++) {
            if(ifzero==0){
                for (int j = 0; j <common; j++) {
                    if(i>0&&i<numRows-1){
                        b= b + s.charAt(j*group+i)+s.charAt(j*group+group-i);
                    }else {
                        b= b + s.charAt(j*group+i);
                    }

                }
            }else {
                for (int j = 0; j <common+1; j++) {
                    if((j*group+i)<s.length()){
                        if(i>0&&i<numRows-1){
                            if((j*group+i)<s.length()){
                                b= b + s.charAt(j*group+i);
                            }
                            if((j*group+group-i)<s.length()){
                                b = b + s.charAt(j*group+group-i);
                            }
                        }else {
                            b= b + s.charAt(j*group+i);
                        }
                    }
                }
            }
        }
        return b;
    }
}

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
class Solution0051 {

    public String longestPalindrome(String s) {


        String str="";
        if(s.length()<2){
            return s;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }else {
                return ""+s.charAt(0);
            }
        }
        int j = 0 ;
        for (int i = 0 ; i < s.length()-1; i++) {//保证i与i+1不会空指针
            if(s.charAt(i)==s.charAt(i+1)){
                if(i>0&&i<s.length()-1){
                    if(s.charAt(i-1)==s.charAt(i)){
                        j = 1;
                        while (s.charAt(i-j) == s.charAt(i+j)){
                            String st = s.substring(i-j,i+j+1);
                            if(str.length()<st.length()){
                                str = st;
                            }
                            if(i-j>0&&i+1+j<s.length()){
                                j++;
                            }else {
                                break;
                            }
                        }
                        j = 0 ;
                    }
                }
                while (s.charAt(i-j)==s.charAt(i+j+1)){
                    String st = s.substring(i-j,i+j+2);
                    if(str.length()<st.length()){
                        str = st;
                    }
                    if(i-j>0&&i+2+j<s.length()){
                        j++;
                    }else {
                        break;
                    }
                }
                j = 0 ;
            }else {
                while (s.charAt(i-j) == s.charAt(i+j)){
                    String st = s.substring(i-j,i+j+1);
                    if(str.length()<st.length()){
                        str = st;
                    }
                    if(i-j>0&&i+1+j<s.length()){
                        j++;
                    }else {
                        break;
                    }
                }

                j = 0 ;
            }
        }

        return str;
    }
}

class Solution0031{
    public int lengthOfLongestSubstring(String s) {
        if(s==""||s.equals("")){
            return 0;
        }
        Set set = new HashSet();
        for (int i = 0; i <s.length() ; i++) {
            set.add(s.charAt(i));
        }
        if(set.size()==s.length()){
            return s.length();
        }

        int big = 1;
        for (int i = 0; i < s.length()-1; i++) {
            Map map = new HashMap();
            map.put(i,s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {

                if(map.containsValue(s.charAt(j))){

                    big = (big>(j-i))?big:j-i;
                    break;
                }else {
                    if(j==s.length()-1){
                        big = (big>(j+1-i))?big:j+1-i;
                    }else {
                        map.put(j, s.charAt(j));
                    }
                }
            };
        }
        return big;
    }
}

class Solution0021 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}


/**                 Solution001
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 ********************************************************
 *示例:
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 ********************************************************
 */
//
class Solution0011{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        System.out.println("meiyuma");
        return null;
    }
}
//

class Solution0012 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
//

class Solution0013{
    public List<List<Integer>> twoSum(int[] nums, int target) {
        if(nums.length<2){
            throw new IllegalArgumentException("No two nums");
        }else {
            Arrays.sort(nums);//排序
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        lists.add(list);
                    }
                }
            }
            return removeDuplicates(lists);
        }

    }

    private static List<List<Integer>> removeDuplicates(List<List<Integer>> lists){
        List<List<Integer>> lists1 = new ArrayList<>();
        lists1.add(lists.get(0));
        for (int i = 1; i < lists.size(); i++) {
            if(lists.get(i).get(0)==lists.get(i-1).get(0)&&lists.get(i).get(0)==lists.get(i).get(0)){
                continue;
            }else {
                lists1.add(lists.get(i));
            }
        }

        if(lists1.size()==0){
            throw new IllegalArgumentException("No two sum");
        }else {
            return lists1;
        }
    }
}
/**
 *
 */
/**********************************************************/
//////////////////////////////////////////////////////////////////////////////////////////////
/**                 Solution002
 *
 *
 *
 */


//////////////////////////////////////////////////////////////////////////////////////////////






//////////////////////////////////////////////////////////////////////////////////////////////
