import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    /**
     * Sample Input
     * H1 America
     * H2 North America
     * 
     * Sample Output
     * <ul><li>America
     * <ul><li>North America
     * </li></ul></li></ul>
     */
    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }

    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Heading> headings = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            headings.add(parse(line));
        }
        Node outline = toOutline(headings);
        String html = toHtml(outline);
        System.out.println(html);
    }

    private static Node toOutline(List<Heading> headings) {
        // Implement this function. Sample code below builds an
        // outline of only the first heading.

        Node root = new Node(new Heading(0, ""));
        for (Heading head : headings) {
            // recursive function to iterate nodes
            iterateNodes(root, head, null);
        }
        return root;
    }

    private static Node iterateNodes(Node root, Heading head, Node parent) {
        int currentNodeWeight = root.heading.weight;
        List<Node> children = root.children;
        int childrenSize = children.size();
        if (!root.children.isEmpty()) {
            if (childrenSize > 0) {
                if (head.weight > currentNodeWeight) {
                    iterateNodes(children.get(childrenSize - 1), head, root);
                } else if (head.weight == currentNodeWeight) {
                    parent.children.add(new Node(head));
                } else {
                    System.out.println("Something is Wrong!");
                }
            } else {
                System.out.println("Children size Else??");
            }
        } else {
            if( head.weight > currentNodeWeight ) {
                root.children.add(new Node(head));
            } else {
                parent.children.add(new Node(head));
            }
        }
        return root;
    }


    /**
     * Parses a line of input.
     * This implementation is correct for all predefined test cases.
     */
    private static Heading parse(String record) {
        String[] parts = record.split(" ", 2);
        int weight = Integer.parseInt(parts[0].substring(1));
        Heading heading = new Heading(weight, parts[1].trim());
        return heading;
    }

    /**
     * Converts a node to HTML.
     * This implementation is correct for all predefined test cases.
     */
    private static String toHtml(Node node) {
        StringBuilder buf = new StringBuilder();
        if (!node.heading.text.isEmpty()) {
            buf.append(node.heading.text);
            buf.append("\n");
        }
        Iterator<Node> iter = node.children.iterator();
        if (iter.hasNext()) {
            buf.append("<ul>");

            while (iter.hasNext()) {
                Node child = iter.next();
                buf.append("<li>");
                buf.append(toHtml(child));
                buf.append("</li>");
                if (iter.hasNext()) {
                    buf.append("\n");
                }
            }
            buf.append("</ul>");
        }
        return buf.toString();
    }
}
