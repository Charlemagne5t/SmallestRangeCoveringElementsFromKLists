import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Num> merged = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                merged.add(new Num(nums.get(i).get(j), i));
            }
        }
        Collections.sort(merged, Comparator.comparing( (Num n) -> n.num));
        List<Nums> ns = new ArrayList<>();
        for(Num x : merged) {
            if(ns.isEmpty() || ns.get(ns.size() - 1).num != x.num){
                ns.add(new Nums(x.num, x.from));
            }else {
                ns.get(ns.size() - 1).from.add(x.from);
            }
        }
        int min = Integer.MAX_VALUE;
        int resI = -1;
        int resJ = -1;

        int k = nums.size();
        int[] count = new int[k];
        int start = 0;
        for(int end = 0; end < ns.size(); end++) {

            for(int from : ns.get(end).from) {
                count[from]++;
                if(count[from] == 1) {
                    k--;
                }
            }
            while(k == 0 && start <= end) {
                if(ns.get(end).num - ns.get(start).num < min) {
                    min = ns.get(end).num - ns.get(start).num;
                    resJ = ns.get(end).num;
                    resI = ns.get(start).num;
                }

                for(int from : ns.get(start).from) {
                    count[from]--;
                    if(count[from] == 0) {
                        k++;
                    }
                }
                start++;
            }
        }


        return new int[]{resI, resJ};
    }

}
class Num {
    int num;
    int from;
    Num(int num, int from) {
        this.num = num;
        this.from = from;
    }
}
class Nums {
    int num;
    Set<Integer> from = new HashSet<>();
    Nums(int num, int from) {
        this.num = num;
        this.from.add(from);
    }

    @Override
    public String toString() {
        return "Nums{" +
                "num=" + num +
                ", from=" + from +
                '}';
    }
}