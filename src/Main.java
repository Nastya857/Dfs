import java.util.*;

class Main {
    private static final HashMap<Integer, String> idToName = new HashMap<>();

    static {
        idToName.put(1, "Брест");
        idToName.put(2, "Виальнюс");
        idToName.put(3, "Витебск");
        idToName.put(4, "Калининград");
        idToName.put(6, "Даугавпилс");
        idToName.put(7, "Киев");
        idToName.put(8, "Каунас");
        idToName.put(9, "Воронеж");
        idToName.put(10, "Орел");
        idToName.put(11, "Волгоград");
        idToName.put(12, "Ниж.Новогород");
        idToName.put(13, "спб");
        idToName.put(14, "Харьков");
        idToName.put(15, "Кишинев");
        idToName.put(16, "Симферополь");
        idToName.put(17, "Одесса");
        idToName.put(18, "Рига");
        idToName.put(19, "Ярославль");
        idToName.put(20, "Донецк");
        idToName.put(21, "Москва");
        idToName.put(22, "Житомир");
        idToName.put(23, "Таллин");
        idToName.put(24, "Минск");
        idToName.put(25, "Казань");
        idToName.put(26, "Мурманск");
    }

    private final List<Integer>[] adjLists;
    private final boolean[] visited;

    private Main(int vertices) {
        adjLists = new ArrayList<>[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new ArrayList<>();
    }

    void addEdge(int vertex1, int vertex2) {
        adjLists[vertex1].add(vertex2);
        adjLists[vertex2].add(vertex1);
    }

    public List<Integer> findPath(int from, int to) {
        List<Integer> path = new ArrayList<>();
        dfs(from, to, path);
        return path;
    }

    private boolean dfs(int v, int to, List<Integer> currentPath) {
        visited[v] = true;
        currentPath.add(v);
        if (v == to) {
            return true;
        }

        for (Integer u : adjLists[v]) {
            if (!visited[u] && dfs(u, to, currentPath)) {
                return true;
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited[v] = false;
        return false;
    }

    public static void main(String[] args) {
        Main g = new Main(27);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 6);
        g.addEdge(2, 8);
        g.addEdge(2, 7);
        g.addEdge(7, 14);
        g.addEdge(7, 15);
        g.addEdge(7, 16);
        g.addEdge(7, 17);
        g.addEdge(8, 18);
        g.addEdge(8, 23);
        g.addEdge(3, 9);
        g.addEdge(3, 10);
        g.addEdge(3, 11);
        g.addEdge(3, 12);
        g.addEdge(9, 19);
        g.addEdge(19, 24);
        g.addEdge(24, 26);
        g.addEdge(10, 20);
        g.addEdge(10, 21);
        g.addEdge(21, 25);
        g.addEdge(11, 22);
        g.addEdge(4, 13);

        List<Integer> res = g.findPath(1, 25);
        for (Integer item : res) {
            System.out.printf("%s ", idToName.get(item));
        }
        System.out.println();
    }
}