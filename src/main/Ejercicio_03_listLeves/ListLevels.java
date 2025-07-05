package main.Ejercicio_03_listLeves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.Materia.Models.*;

public class ListLevels {


    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                level.add(current);

                if (current.getLeft() != null) queue.offer(current.getLeft());
                if (current.getRight() != null) queue.offer(current.getRight());
            }

            result.add(level);
        }

        return result;
    }
}
