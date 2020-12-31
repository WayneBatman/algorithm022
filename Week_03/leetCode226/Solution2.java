class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.pop();
            TreeNode temp =current.right;
            current.right = current.left;
            current.left = temp;

            if(current.left != null){
                queue.push(current.left);
            }

            if(current.right != null){
                queue.push(current.right);
            }
        }

        return root;
    }
}