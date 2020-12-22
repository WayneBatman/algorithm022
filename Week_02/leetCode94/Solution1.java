class Solution1 {
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        dfs(root,result);

        return result;

    }

    private void dfs(TreeNode current, List<Integer> result) {
        if(current == null){
            return;
        }

        //中序遍历 左根右
        if(current.left != null){
            dfs(current.left,result);
        }
        result.add(current.val);
        if(current.right != null){
            dfs(current.right,result);
        }

    }
}