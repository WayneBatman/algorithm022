class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while (root != null ||!stack.isEmpty()){

            while (root != null ){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;

        }


        return result;

    }
}