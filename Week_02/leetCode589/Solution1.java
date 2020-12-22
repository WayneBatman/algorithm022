class Solution {

    //递归
    public List<Integer> preorder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        dfs(root,result);

        return result;
    }

    private void dfs(Node current, List<Integer> result) {
        if(current == null){
            return;
        }

        //前序遍历 根左右
        result.add(current.val);

        if(current.children != null && current.children.size() > 0){
            for(Node child : current.children){
                dfs(child,result);
            }
        }

    }
}