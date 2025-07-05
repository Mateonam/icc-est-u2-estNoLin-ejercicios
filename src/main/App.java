package main;

import java.util.List;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import utils.StudentValidator;
import main.Materia.Models.*;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ

        InsertBST inserter = new InsertBST();
        Node root = null;

        // Ejercicio 01 - Insertar en el BST
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int v : values) {
            root = inserter.insert(root, v);
        }

        System.out.println("Ejercicio 01 - Árbol BST por niveles:");
        printLevels(root);
        System.out.println();

        // Ejercicio 02 - Invertir el árbol
        InvertBinaryTree inverter = new InvertBinaryTree();
        Node inverted = inverter.invertTree(root);
        System.out.println("Ejercicio 02 - Árbol invertido por niveles:");
        printLevels(inverted);
        System.out.println();

        // Ejercicio 03 - Listar niveles en listas enlazadas
        System.out.println("Ejercicio 03 - Listar niveles (Listas enlazadas simuladas):");
        ListLevels lister = new ListLevels();
        List<List<Node>> levels = lister.listLevels(inverted);
        for (int i = 0; i < levels.size(); i++) {
            for (int j = 0; j < levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j).getValue());
                if (j < levels.get(i).size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
        System.out.println();

        // Ejercicio 04 - Profundidad máxima
        Depth depthCalc = new Depth();
        int depth = depthCalc.maxDepth(inverted);
        System.out.println("Ejercicio 04 - Profundidad máxima del árbol: " + depth);
    }

    public static void printLevels(Node root) {
        ListLevels lister = new ListLevels();
        List<List<Node>> levels = lister.listLevels(root);

        for (List<Node> level : levels) {
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i).getValue());
                if (i < level.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

}
