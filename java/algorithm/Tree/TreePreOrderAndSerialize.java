public class TreePreOrderAndSerialize {

    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.getData()+ " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }else {
            return;
        }
    }

    public static String serialize(Node root){
        StringBuilder result = new StringBuilder();
        preSerialize(root, result);

        return result.toString();
    }

    public static void preSerialize(Node root, StringBuilder result){
        if(root!=null){
            result.append(root.getData() + "!");
        }else{
            result.append("#!");
            return;
        }
        preSerialize(root.getLeft(), result);
        preSerialize(root.getRight(), result);
    }

    static int beginIndex = 0;
    static int endIndex = 0;

    public static Node deSerialize(String fromString){
        beginIndex = 0;
        endIndex = 0;
        Node result = preDeSerialize(fromString);
        return result;
    }

    public static Node preDeSerialize(String fromString){
        endIndex = beginIndex + fromString.substring(beginIndex).indexOf('!');
        String subString = fromString.substring(beginIndex,endIndex);
        beginIndex = endIndex+1;
        if(subString.equals("#")){
            return null;
        }else {
            Node node = new Node(Integer.parseInt(subString));
            node.setLeft(preDeSerialize(fromString));
            node.setRight(preDeSerialize(fromString));
            return node;
        }
    }
}
