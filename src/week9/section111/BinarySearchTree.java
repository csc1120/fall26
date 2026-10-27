/*
 * Course: CSC-1120
 * ASSIGNMENT
 * CLASS
 * Name: Sean Jones
 * Last Updated:
 */
package week9.section111;

public class BinarySearchTree {










    @Override
    public String toString() {
        if(this.root == null) {
            return "null\n";
        }

        int height = this.height(this.root);
        int labelWidth = this.maxLabelWidth(this.root);
        int unit = labelWidth + 2;
        int width = (1 << height) * unit + labelWidth;
        int rows = height * 2 - 1;
        char[][] canvas = new char[rows][width];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < width; c++) {
                canvas[r][c] = ' ';
            }
        }

        int rootX = width / 2;
        this.drawAscii(this.root, 0, rootX, height, unit, canvas);

        StringBuilder sb = new StringBuilder();
        for(char[] row : canvas) {
            int end = row.length - 1;
            while(end >= 0 && row[end] == ' ') {
                end--;
            }
            if(end >= 0) {
                sb.append(row, 0, end + 1);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private int height(Node<E> node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(this.height(node.left), this.height(node.right));
    }

    private int maxLabelWidth(Node<E> node) {
        if(node == null) {
            return 0;
        }
        int current = String.valueOf(node.data).length();
        int left = this.maxLabelWidth(node.left);
        int right = this.maxLabelWidth(node.right);
        return Math.max(current, Math.max(left, right));
    }

    private void drawAscii(Node<E> node, int depth, int x,
                           int height, int unit, char[][] canvas) {
        if(node != null) {
            int nodeRow = depth * 2;
            String label = String.valueOf(node.data);
            int start = x - (label.length() / 2);
            for (int i = 0; i < label.length(); i++) {
                int col = start + i;
                if (col >= 0 && col < canvas[nodeRow].length) {
                    canvas[nodeRow][col] = label.charAt(i);
                }
            }

            if (depth < height - 1) {
                int gap = (1 << (height - depth - 2)) * unit;
                int edgeRow = nodeRow + 1;
                if (node.left != null) {
                    int leftX = x - gap;
                    int leftEdge = x - (gap / 2);
                    if (edgeRow < canvas.length
                            && leftEdge >= 0
                            && leftEdge < canvas[edgeRow].length) {
                        canvas[edgeRow][leftEdge] = '/';
                    }
                    this.drawAscii(node.left, depth + 1, leftX, height, unit, canvas);
                }
                if (node.right != null) {
                    int rightX = x + gap;
                    int rightEdge = x + (gap / 2);
                    if (edgeRow < canvas.length
                            && rightEdge >= 0
                            && rightEdge < canvas[edgeRow].length) {
                        canvas[edgeRow][rightEdge] = '\\';
                    }
                    this.drawAscii(node.right, depth + 1, rightX, height, unit, canvas);
                }
            }
        }
    }
}
