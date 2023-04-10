public class lab5 {

    public static boolean isomorphic(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }

        int n = a.length;
        boolean[] used = new boolean[n];
        return dfs(a, b, used, 0);
    }

    private static boolean dfs(int[][] a, int[][] b, boolean[] used, int i) {
        int n = a.length;
        if (i == n) {
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (!used[j]) {
                boolean match = true;
                for (int k = 0; k < n; k++) {
                    if (a[i][k] != b[j][k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    used[j] = true;
                    if (dfs(a, b, used, i+1)) {
                        return true;
                    }
                    used[j] = false;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int[][] b = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};

        boolean isIsomorphic = isomorphic(a, b);
        System.out.println("Чи ці графи ізоморфні? - " + isIsomorphic);
    }
}