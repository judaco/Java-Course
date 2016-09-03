package com.company;

public class Main {

        public static void main(String[] args) {
            /*Node n1 = new Node(5);
            Node n2 = new Node(100);
            Node n3 = new Node(500);
            Node n4 = new Node(250);

            n1.left = n2;
            n1.right = n3;
            n3.left = n4;*/

            Node n1 = null;
            Node n2 = null;
            System.out.println(n1 == n2);
        }

        public static int max(Node node){
            int max = node.value;
            if (node.left != null){
                int maxLeft = max(node.left);
                if (maxLeft > max)
                    max = maxLeft;
            }
            if (node.right != null){
                int maxRight = max(node.right);
                if (maxRight > max)
                    max = maxRight;
            }
            return max;
        }

        public static int sum(Node node) {
            int sum = 0;
            return sum;
        }

        public static boolean compare(Node node1, Node node2){
            if(node1 == node2)
                return true;
            if((node1 == null && node2 != null) || (node1 != null && node2 == null))
                return false;
            if(node1.value != node2.value)
                return false;
            return compare(node1.left, node2.left) && compare(node1.right, node2.right);
        }
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int max() {//this is not static
            int max = value;
            if (left != null) {
                int maxLeft = left.max();
                if (maxLeft > max)
                    max = maxLeft;
            }
            if (right != null) {
                int maxRight = right.max();
                if (maxRight > max)
                    max = maxRight;
            }
            return max;

        }

        public int sum() {
            int sum = value;
            if (left != null)
                sum += left.sum();
            if (right != null)
                sum += right.sum();
            return sum;
        }


        @Override
        public boolean equals(Object obj) {
            if(obj == null)
                return false;
            if(obj == this)
                return true;
            if(obj instanceof Node){
                Node other = (Node)obj;
                if(this.value != other.value)
                    return false;
                if(this.right != null){
                    if(other.right == null)
                        return false;
                    if(!this.right.equals(other.right))
                        return false;
                }else{
                    if(other.right != null)
                        return false;
                }
                if(this.left != null){
                    if(other.left == null)
                        return false;
                    if(!this.left.equals(other.left))
                        return false;
                }else{
                    if(other.left != null)
                        return false;
                }
                return true;
            }
            return false;
        }
    }

