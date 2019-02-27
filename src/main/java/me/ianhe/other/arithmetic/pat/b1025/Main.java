package me.ianhe.other.arithmetic.pat.b1025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:29
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int nc = sc.nextInt();
        ArrayList<Node> ll = new ArrayList<>();
        int k = sc.nextInt();
        //节点地址-节点映射
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        while (nc != 0) {
            int ad = sc.nextInt();
            int val = sc.nextInt();
            int next = sc.nextInt();
            map.put(ad, new Node(ad, val, next));
            nc--;
        }
        sc.close();

        //把链表按给出顺序排列,放入集合中
        while (first != -1) {
            Node n = map.get(first);
            ll.add(n);
            first = n.next;
        }

        //每k位逆转顺序
        for (int i = k; i < ll.size(); i += k) {
            int l = i - k;
            int r = i - 1;
            while (l < r) {
                Node t = ll.get(l);
                ll.set(l, ll.get(r));
                ll.set(r, t);
                l++;
                r--;
            }
        }

        //输出结果,地址小于5位前面补0
        for (int i = 0; i < ll.size() - 1; i++) {
            StringBuilder str = new StringBuilder("" + ll.get(i).address);
            StringBuilder str2 = new StringBuilder("" + ll.get(i + 1).address);
            while (str.length() < 5) {
                str.insert(0, "0");
            }
            while (str2.length() < 5) {
                str2.insert(0, "0");
            }
            System.out.println(str + " " + ll.get(i).val + " " + str2);
        }
        StringBuilder str = new StringBuilder("" + ll.get(ll.size() - 1).address);
        while (str.length() < 5) {
            str.insert(0, "0");
        }
        System.out.println(str + " " + ll.get(ll.size() - 1).val + " -1");

    }

    static class Node {
        public Node(int adr, int v, int next) {
            address = adr;
            val = v;
            this.next = next;
        }

        int address;
        int val;
        int next;
    }
}
