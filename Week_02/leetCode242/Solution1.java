class Solution1 {
    public boolean isAnagram(String s, String t) {

        //hash表
        Map<Character,Integer> table = new HashMap<>();

        for(Character c:s.toCharArray()){
            Integer nums = table.get(c) == null?0:table.get(c);
            nums++;
            table.put(c,nums);
        }

        for(Character c:t.toCharArray()){
            Integer nums = table.get(c) == null?0:table.get(c);
            nums--;
            table.put(c,nums);
        }

        Set<Character> characters = table.keySet();

        for(Character c:characters){
            if(table.get(c) != 0){
                return false;
            }
        }

        return true;
    }
}