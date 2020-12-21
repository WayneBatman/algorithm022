class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null && nums.length < 2){
            return null;
        }

        int[] result = new int[2];

        boolean find = false;

        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(target == nums[i]+nums[j]){
                    result[0] = i;
                    result[1] = j;
                    find = true;
                    break;
                }
            }

            if(find){
                break;
            }
        }

        return result;
    }
}