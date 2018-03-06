public class TreeWithParentFindNext {
    /*
    有父节点的树，给定一个节点返回后继节点.
    1、如果node有右子树，那么后继节点就是右子树最左边节点
    2、如果node节点没有右子树，那么先看node是不是node父节点的左孩子，如果是左孩子，那么此时node的父节点
    就是node的后继节点。如果是右孩子，就向上寻找node的后继节点，假如向上移动到的节点记为s，s的父亲节点记为p，
    如果发现s是p的左孩子，那么节点p就是node节点的后继节点，否则就一直向上移动。
     */
    public TreeNode find(TreeNode node){
        if(node.rightChild!=null){
            return node.rightChild;
        }
        TreeNode parent = node.parent;
        TreeNode temp = node;
        while(parent!=null){
            if(parent.leftChild!=null&&
                    parent.leftChild==temp){
                return parent;
            }
            parent = parent.parent;
            temp = parent;
        }
        return null;
    }
}
