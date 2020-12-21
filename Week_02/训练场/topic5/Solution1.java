class Solution1 {
    //核心思想，借用循环链表的思想，实际上判断两个循环链表是否一致
    public String findSameSnow(int[][] snows) {
        if(snows == null || snows.length <=1){
            return "No";
        }

        Set<String> temp = new HashSet<>();

        for(int[] snow :snows){
            //找到当前雪花中最短的臂长
            int n = 10000000;//题目中臂长范围 0<n<=10000000
            int minIndex = 0;
            for(int i = 0;i<6;i++){//雪花有6个臂
                if(snow[i] <= n){
                    n = snow[i];
                    minIndex=i;
                }
            }

            StringBuffer left = new StringBuffer(14);
            //向左遍历,即以最小值所在的索引为起点，向数组起始位置遍历；
            //到头后，再从尾开始遍历到最小值处
            for(int i = minIndex;i>=0;i--){
                left.append(snow[i]).append(",");//加个逗号分隔，避免类似 1,12;11,2这种
            }

            for(int i = snow.length-1;i>= minIndex;i--){
                left.append(snow[i]).append(",");
            }

            //遍历后的值放入set中
            //如果不能放，则表明雪花可能相同，返回Yes
            if(!temp.add(left.toString())){
                return "Yes";
            }

            StringBuffer right = new StringBuffer(14);
            //向右遍历，即以最小值所在的索引为起点，向数组尾部位置遍历;
            //到尾部,在从头开始遍历到最小值处
            for(int i = minIndex;i<snow.length;i++){
                right.append(snow[i]).append(",");
            }

            for(int i = 0;i<=minIndex;i++){
                right.append(snow[i]).append(",");
            }

            //遍历后的值放入set中
            //如果不能放，则表明雪花可能相同，返回Yes
            if(!temp.add(right.toString())){
                return "Yes";
            }
        }

        //一直没有返回，则返回"No"
        return "No";
    }
}
