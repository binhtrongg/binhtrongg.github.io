public class LC100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 1 trong 2 null->false
        if (p == null || q == null) {
            return false;
        }
        // value khác nhau-> false
        if (p.val != q.val) {
            return false;
        }
        // đệ quy kiểm tra sub tree
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
//    time:O(n) với n là số nút
//    space:0(h) với h là chiều cao cây
}
