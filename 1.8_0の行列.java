//問題
/*
M×Nの行列について、要素が0であればその行と列を全て0にするアルゴリズムを書いてください。
*/

//解法１
/*
①行、列のboolean配列を作成する
②二次元配列の全ての要素に対して0かどうかの判定を行い、0の時該当する行と列のbooleanをtrueとする
③行、列、それぞれに対してtrueの行、列を0で埋める。
*/

void setZeros(int[][] matrix) {
    boolean[] row = new boolean[matrix.length()];
    boolean[] column = new boolean[matrix[0].length()];
    for (int i = 0; i < matrix.length(); i++) {
        for (int j = 0; j < matrix[0].length(); j++) {
            if (matrix[i][j] == 0) {
                row[i] = true;
                column[j] = true;
            }
        }
    }
    for (int i = 0; i < row.length(); i++) {
        if (row[i]) nullyfyRow(matrix, i);
    }
    for (int i = 0; i < column.length(); i++) {
        if (column[i]) nullyfyColumn(matrix, i);
    }
    void nullyfyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length(); i++) {
            matrix[row][i] = 0;
        }
    }
    void nullyfyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length(); i++) {
            matrix[i][col] = 0;
        }
    }
}