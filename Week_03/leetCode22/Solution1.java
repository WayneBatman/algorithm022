class Solution1 {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0,0,n,"");
        return result;
    }

    private void generate(int left, int right, int max, String s) {
        if(left == max && right == max){
            result.add(s);
            return;
        }

        if(left < max){
            generate(left+1,right,max,s+"(");
        }

        if(right < left){
            generate(left,right+1,max,s+")");
        }

    }
}