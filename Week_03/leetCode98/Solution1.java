class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double min = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(root.val <= min){
                return false;
            }

            min = root.val;
            root = root.right;
        }

        return true;
    }
}