package com.nlpeng.arithmetic;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Ferry NLP
 * @create 2019-09-02
 * @see
 * @since 1.0v
 **/
public class leetcode11_20 {
    public static void main(String[] args) {
        System.out.println("--------------------------Solution0011  BEGIN--------------------------");
        Solution0191 solution0191 = new Solution0191();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next= new ListNode(5);
        solution0191.removeNthFromEnd(listNode,2);
        System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0201  BEGIN--------------------------");
        Solution0201 solution0201 = new Solution0201();
        System.out.println(solution0201.isValid("(])"));
        System.out.println("--------------------------Solution0201  END----------------------------");
    
    }
}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 */
class Solution0201 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char c:chars) {
            if(c=='('||c=='{'||c=='['){
               stack.push(c);
            }
            if(c==')'||c=='}'||c==']'){
                if (stack.empty()){
                    return false;
                }
                char b = (char)stack.lastElement();
                if(c==')'&&b=='('){
                    stack.pop();
                }else if(c=='}'&&b=='{'){
                    stack.pop();
                }else if(c==']'&&b=='['){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *      给定的 n 保证是有效的。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution0191 {
    int count = 1;
    int size = 1;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(0);
        zero.next= head;
        int sum = hasCount(head);
        hasNext(zero,sum-n+1);
        return zero.next;
    }
    private int hasCount(ListNode listNode){
        if (listNode.next!=null){
            size++;
            return hasCount(listNode.next);
        }else {
            return size;
        }
    }
    private ListNode hasNext(ListNode listNode,int n){
        if (count==n){
            listNode.next = listNode.next.next;
            return listNode;
        }else {
            if (listNode.next==null){
                return listNode;
            }else {
                count++;
                return hasNext(listNode.next,n);
            }
        }
        
    }
}

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 */
class Solution0181 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);//排序
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = nums.length; i >= 3 ;i--) {
            int a = i - 3;
            int b = i - 2;
            int c = i - 1;
            int d = i;
            if(nums[a]+nums[b]+nums[c]+nums[d] == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[a]);
                list.add(nums[b]);
                list.add(nums[c]);
                list.add(nums[d]);
                lists.add(list);
            }else if(nums[a]+nums[b]+nums[c]+nums[d]>target){
                a--;
            }

        }

        return lists;
    }
}

class Solution0171 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <digits.length() ; i++) {
            String str = number(String.valueOf(digits.charAt(i)));

        }


        return list;
    }
    private String breakon(String str){
        for (int i = 0; i <str.length() ; i++) {

        }
        return "";
    }

    private String number(String str){
        if(str=="1"){
            return "";
        }else if(str=="2"){
            return "abc";
        }else if(str=="3"){
            return "def";
        }else if(str=="4"){
            return "ghi";
        }else if(str=="5"){
            return "jkl";
        }else if(str=="6"){
            return "mno";
        }else if(str=="7"){
            return "pqrs";
        }else if(str=="8"){
            return "tuv";
        }else if(str=="9"){
            return "wxyz";
        }else if(str=="0"){
            return "";
        }else {
            return "";
        }
    }


}

//[-1,2,1,-4]
//1
class Solution0161 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 排序
        int len = nums.length;
        int j ;
        int ans = nums[0]+nums[1]+nums[2] ;
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len-1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(ans-target)>Math.abs(sum-target)){
                    ans = sum;
                }
                if(sum>target){
                    R--;
                }else if(sum<target){
                    L++;
                }else {
                    return ans;
                }
            }
        }
        return ans;

    }
}


class Solution0152{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 排序
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) L--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return lists;
    }
}

class Solution0151{
    public List<List<Integer>> threeSum(int[] nums) {
        int m = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(0==nums[i]){
                m++;
            }
        }
        List list = new ArrayList();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            for (int j = i+1; j <nums.length-1 ; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> inter = new ArrayList();
                        inter.add(nums[i]);
                        inter.add(nums[j]);
                        inter.add(nums[k]);
                        lists.add(inter);
                    }
                }
            }
        }


        for (int i = 0; i < lists.size()-1 ; i++) {
            for (int j = i+1; j <lists.size() ; j++) {
                if(!compare(lists.get(i),lists.get(j))){
                    list.add(lists.get(i));
                }
            }
        }

        List<Integer> zero = new ArrayList();
        zero.add(0);
        zero.add(0);
        zero.add(0);
        if(lists.contains(zero)){

        }else {
            if(m>3){
                list.add(zero);
            }
        }
        return list;
    }


    private boolean compare(List<Integer> listA,List<Integer> listB){
        Set set3  = new HashSet<>();

        for (Integer i: listA) {
            set3.add(i);
        }
        int lb = set3.size();
        for (Integer j:listB) {
            set3.add(j);
        }
        int la = set3.size();
        return lb==la;
    }


}

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *         如果不存在公共前缀，返回空字符串 ""。
 */
class Solution0141 {
    public String longestCommonPrefix(String[] strs) {
        String str= strs[0];
        int l = strs[0].length();
        int ind = 0 ;
        for (int i = 0; i < strs.length; i++) {
            l = Math.min(strs[i].length(),l);
        }
        if(l==0){
            return "";
        }

        outer:
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(str.substring(0,i).equals(strs[j].substring(0,i))){
                    ind = i;
                }else {
                    ind = i-1;
                    break outer ;
                }
            }
        }

        return strs[0].substring(0,ind);
    }
}

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
class Solution0111 {
    public String intToRoman(int num) {
        StringBuffer s = new StringBuffer();
        while (num != 0) {
            if (num >= 1000) {
                s.append("M");
                num -= 1000;
            } else if (num >= 900) {
                s.append("CM");
                num -= 900;
            } else if (num >= 500) {
                s.append("D");
                num -= 500;
            } else if (num >= 400) {
                s.append("CD");
                num -= 400;
            } else if (num >= 100) {
                s.append("C");
                num -= 100;
            } else if (num >= 90) {
                s.append("XC");
                num -= 90;
            } else if (num >= 50) {
                s.append("L");
                num -= 50;
            } else if (num >= 40) {
                s.append("XL");
                num -= 40;
            } else if (num >= 10) {
                s.append("X");
                num -= 10;
            } else if (num >= 9) {
                s.append("IX");
                num -= 9;
            } else if (num >= 5) {
                s.append("V");
                num -= 5;
            } else if (num >= 4) {
                s.append("IV");
                num -= 4;
            } else if (num >= 1) {
                s.append("I");
                num -= 1;
            }
        }
        return s.toString();
    }
}









