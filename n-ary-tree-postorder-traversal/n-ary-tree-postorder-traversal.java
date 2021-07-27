/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans=new ArrayList();
    public List<Integer> postorder(Node root) {
        ispost(root,ans);
        return ans;
    }
    public void ispost(Node root, List<Integer> ans)
    {
        if(root==null)
            return;
        for(Node n:root.children)
            ispost(n,ans);
        ans.add(root.val);
    }
}