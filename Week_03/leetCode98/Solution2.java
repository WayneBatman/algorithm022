class Solution2 {

    double min = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(root.val <= min){
            return false;
        }

        min = root.val;

        return isValidBST(root.right);

    }
}