class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }

        List<List<String>> result= new ArrayList<>();

        Map<String,List<String>> temp = new HashMap<>();

        int i = 0;
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> strings = temp.get(key);
            if (strings == null){
                strings = new ArrayList<>();
            }
            strings.add(str);
            temp.put(key,strings);
        }

        for(String key : temp.keySet()){
            result.add(temp.get(key));
        }


        return result;

    }