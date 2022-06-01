
//問題
/*
2つの文字列が与えられたとき、片方がもう片方の並び替えになっているかどうかを決定するメソッドを書いてください。
*/

//解答前の確認事項
/*
・大文字と小文字の区別（Godはdogの順列と言えるのかどうか）
・空白がある時にどうするのか
・長さの異なる文字列が順列になることはないので、先に最適化しておく。
*/

//解法１：２つの文字列をそれぞれソートして比較する

import java.util.Arrays;

String sort(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    return sort(s).equals(sort(t));
}

//解法２：同じ文字の数を数える（２つの文字列には全く同じ文字が使われていることを利用する）
//ハッシュテーブルを用意して、１つ目の文字列でインクリメント、２つ目の文字列でデクリメントを行う。値が負となる時点でfalseとなる。
//最終的に全て0になるときにtrueを返す。

boolean permutation(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] letters = new int[128]; //ASCIIと仮定
    for (int i = 0; i < s.length(); i++) {
        letters[s.charAt(i)]++;
    }

    for (int i = 0; i < t.length(); i++) {
        letters[t.charAt(i)]--;
        if (letters[t.charAt(i)] < 0) {
            return false;
        }
    }

    return true;
}



