package com.nlpeng.arithmetic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ferry NLP
 * @create 2029-09-02
 * @see
 * @since 1.0v
 **/
public class leetcode21_30 {
	public static void main(String[] args) {
		System.out.println("--------------------------Solution0011  BEGIN--------------------------");
		Solution0211 solution0211 = new Solution0211();
		ListNode listNode1 = new ListNode(1);
		listNode1.next = new ListNode(2);
		listNode1.next.next = new ListNode(4);
		//listNode1.next.next.next = new ListNode(4);
		//listNode1.next.next.next.next= new ListNode(5);
		ListNode listNode2 = new ListNode(1);
		listNode2.next = new ListNode(3);
		listNode2.next.next = new ListNode(4);
		//listNode2.next.next.next = new ListNode(4);
		//listNode2.next.next.next.next= new ListNode(5);
		ListNode listNode = solution0211.mergeTwoLists(listNode1, listNode2);
		//soutNext(listNode);
		System.out.println("--------------------------Solution0011  END----------------------------");
        System.out.println("--------------------------Solution0231  BEGIN--------------------------");
        Solution0231 solution0231 = new Solution0231();
        
        ListNode listNode2311 = new ListNode(1);
        listNode2311.next = new ListNode(4);
        listNode2311.next.next = new ListNode(5);
        //listNode1.next.next.next = new ListNode(4);
        //listNode1.next.next.next.next= new ListNode(5);
        ListNode listNode2312 = new ListNode(1);
        listNode2312.next = new ListNode(3);
        listNode2312.next.next = new ListNode(4);
        //listNode2.next.next.next = new ListNode(4);
        //listNode2.next.next.next.next= new ListNode(5);
        ListNode listNode2313 = new ListNode(2);
        listNode2313.next = new ListNode(6);
        //listNode2313.next.next = new ListNode(4);
        ListNode[] lists = new ListNode[3];
        lists[0]= listNode2311;
        lists[1]= listNode2312;
        lists[2]= listNode2313;
        ListNode listNode23119 = solution0231.mergeKLists(lists);
        soutNext(listNode23119);
        System.out.println("--------------------------Solution0231  END----------------------------");
        
    }
	
	public static void soutNext(ListNode listNode) {
		if (listNode.next != null) {
			System.out.print(listNode.next.val + "->");
			soutNext(listNode.next);
		}
	}
}

class Solution0301 {

}

class Solution0291 {

}

class Solution0281 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);//排序
		List<List<Integer>> lists = new ArrayList<>();
		
		for (int i = nums.length; i >= 3; i--) {
			int a = i - 3;
			int b = i - 2;
			int c = i - 1;
			int d = i;
			if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[a]);
				list.add(nums[b]);
				list.add(nums[c]);
				list.add(nums[d]);
				lists.add(list);
			} else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
				a--;
			}
			
		}
		
		return lists;
	}
}

class Solution0271 {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < digits.length(); i++) {
			String str = number(String.valueOf(digits.charAt(i)));
			
		}
		
		
		return list;
	}
	
	private String breakon(String str) {
		for (int i = 0; i < str.length(); i++) {
		
		}
		return "";
	}
	
	private String number(String str) {
		if (str == "1") {
			return "";
		} else if (str == "2") {
			return "abc";
		} else if (str == "3") {
			return "def";
		} else if (str == "4") {
			return "ghi";
		} else if (str == "5") {
			return "jkl";
		} else if (str == "6") {
			return "mno";
		} else if (str == "7") {
			return "pqrs";
		} else if (str == "8") {
			return "tuv";
		} else if (str == "9") {
			return "wxyz";
		} else if (str == "0") {
			return "";
		} else {
			return "";
		}
	}
	
	
}


class Solution0232 {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		queue.addAll(Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toList()));
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null)
				queue.add(node.next);
		}
		return dummy.next;
	}
}


class Solution0231 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode l : lists) {
            List<Integer> is =  new ArrayList<Integer>();
            for (Integer in:hasNext(l,is)) {
                list.add(in);
            }
        }
		list.sort((Comparator.naturalOrder()));
        ListNode listNode = new ListNode(0);
		ListNode listNode1 = addNext(listNode, list);
		return listNode1;
    }
    private List<Integer> hasNext(ListNode listNode,List<Integer> is){
        if (listNode!=null){
            is.add(listNode.val);
            hasNext(listNode.next,is);
        }
        return is;
    }
    int count = 0;
    
    private ListNode addNext(ListNode listNode,List<Integer> is){
        if(count<is.size()){
            listNode.next = new ListNode(is.get(count));
            count++;
            addNext(listNode.next,is);
        }
        return listNode;
    }
    
}

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
class Solution0221 {
	public List<String> generateParenthesis(int n) {
		/**
		 *左括号个数必须大于右括号的放置个数 才能继续放右括号
		 *左括号的个数小于n 才能继续放左括号
		 *左括号和右括号满足上述条件的前提下都为n个，添加这个答案
		 */
		List<String> res = new ArrayList<>();
		generate("", n, n, res);
		return res;
	}
	
	private void generate(String item, int left, int right, List res) {
		//左括号和右括号满足上述条件的前提下都为n个，添加这个答案
		if (left == 0 && right == 0) {
			res.add(item);
			return;
		}
		//左括号的个数小于n 才能继续放左括号
		if (left > 0) {
			generate(item + "(", left - 1, right, res);
		}
		//左括号个数必须大于右括号的放置个数 才能继续放右括号
		if (left < right) {
			generate(item + ")", left, right - 1, res);
		}
	}
	
}

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class Solution0211 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode listNode = new ListNode(0);
		ListNode list = hasNext(l1, l2, listNode);
		return list.next;
	}
	
	private ListNode hasNext(ListNode listNode1, ListNode listNode2, ListNode listNode) {
		
		if (listNode1.val < listNode2.val) {
			listNode.next = new ListNode(listNode1.val);
			if (listNode1.next == null) {
				listNode.next.next = listNode2;
				return listNode;
			} else {
				hasNext(listNode1.next, listNode2, listNode.next);
			}
			
		} else if (listNode1.val >= listNode2.val) {
			listNode.next = new ListNode(listNode2.val);
			if (listNode2.next == null) {
				listNode.next.next = listNode1;
				return listNode;
			} else {
				hasNext(listNode1, listNode2.next, listNode.next);
			}
		}
		return listNode;
	}
}










