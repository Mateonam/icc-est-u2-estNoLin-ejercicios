package main.Ejercicio_02_invert;
import main.Materia.Models.*;
public class InvertBinaryTree {

    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // Intercambiar los hijos izquierdo y derecho
        Node temp = root.getLeft();
        root.setLeft(invertTree(root.getRight()));
        root.setRight(invertTree(temp));

        return root;
    }
}
