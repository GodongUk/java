public class ArrayInArrayExample {
    public static void main(String[] args) {
        int[][] mathScres = new int[2][3];
        for (int i = 0; i < mathScres.length; i++) {
            for (int k = 0; k < mathScres.length; k++) {
                System.out.println("mathScores[" + i + "][" + k + "]="
                        + mathScres[i][k]);
            }
        }
        System.out.println();
        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];
        for (int i = 0; i < englishScores.length; i++) {
            for (int k = 0; k < englishScores.length; k++) {
                System.out.println("englishScores[" + i + "][" + k + "]="
                        + englishScores[i][k]);
            }
        }
        System.out.println();
        int[][] javaScres = { { 95, 80 }, { 92, 96, 80 } };
        for (int i = 0; i < javaScres.length; i++) {
            for (int k = 0; k < javaScres.length; k++) {
                System.out.println("javaScres[" + i + "][" + k + "]="
                        + javaScres[i][k]);
            }
        }
    }
}
