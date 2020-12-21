class Solution2 {
    public boolean isAnagram(String s, String t) {


        //用数组方式做hash表的key
        int[] table = new int[26];

        for(Character c:s.toCharArray()){
            table[c-'a'] = table[c-'a'] + 1;
        }

        for(Character c:t.toCharArray()){
            table[c-'a'] = table[c-'a'] - 1;
        }

        for(int i : table){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}