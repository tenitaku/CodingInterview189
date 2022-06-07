//問題
/*
N×Nの行列に描かれた、一つのピクセルが４バイト四方の画像があります。
その画像を９０度回転させるメソッドを書いてください。これを追加の領域なしでできますか？
*/

//考え方
/*
①行列が０、または縦と横の長さが不一致の時は操作ができないのでfalseを返す。
②行列は正方形であるため、外枠から順に深さn/2まで操作を行う。
③layer = 0 to n/2, first = layer, last = n - 1 - layerとして、for文を用いて回転させていく
④上の値をコピー　-> 左を上に　-> 下を左に -> 右を下に -> 上を右に　で完成
⑤最後にtrueを返す 
⑥変数ofset としてfirst と逆のindexを用意すると分かりやすい。

ポイント：２次元配列のindexは天才でない限り頭の中で整理できないので図に書いて規則性を確かめる
*/
boolean rotate(int[][] matrix) {
    if (matrix.length() == 0 || matrix.length() != matrix[0].length()) return false;

    int n = matrix.length();
    for (int layer = 0; layer < 2 / n; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        for (int i = first; i < last; i++) {
            int ofset = i - first;
            int top = martix[first][i];
            matrix[first][i] = matrix[last - ofset][first]; 
            matrix[last - ofset][first] = matrix[last][last - ofset];
            matrix[last][last - ofset] = matrix[i][last];
            matrix[i][last] = top;
        }
    }
    return true;
}