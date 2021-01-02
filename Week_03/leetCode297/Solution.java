public class Codec {

    private static final String spliter = ",";
    private static final String NN= "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        buildStr(root,sb);

        return sb.toString();
    }

    private void buildStr(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append(NN).append(spliter);
        }else{
            sb.append(root.val).append(spliter);
            buildStr(root.left,sb);
            buildStr(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Deque<String> queue) {
        String val = queue.remove();

        if(val.equals(NN)){
            return null;
        }else{
            TreeNode current = new TreeNode(Integer.valueOf(val));
            current.left = buildTree(queue);
            current.right = buildTree(queue);

            return current;
        }
    }
}