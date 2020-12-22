class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || k<=0){
            return null;
        }

        Map<Integer,Integer> table = new HashMap<>();
        for (int num : nums) {
            table.put(num,table.getOrDefault(num,0)+1);
        }

        //用大顶堆,
        //堆中元素，为一个长度为2的数组，元素0--原数组中的值；元素1--值在原数组中出现的次数
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            Integer num = entry.getKey();
            Integer value = entry.getValue();

            maxHeap.offer(new int[]{num,value});
        }

        int[] res = new int[k];

        for(int i = 0;i<k;i++){
            res[i] = maxHeap.poll()[0];
        }

        return res;
    }
}