class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums == null || k <= 0){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer counts = entry.getValue();

            maxHeap.offer(new int[]{num,counts});
        }

        int size = maxHeap.size();

        int finalLength = k<size?k:size;

        int[] res = new int[finalLength];

        for(int i = 0;i<finalLength;i++){
            res[i] = maxHeap.poll()[0];
        }
        return res;
    }
}