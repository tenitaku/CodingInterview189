
//問題

/*
ある文字列が、全て固有である（重複する文字列がない）かどうかを判定するアルゴリズムを実装してください。
また、それを実装するのに新たなデータ構造が使えない場合、どのようにすれば良いですか？
*/

//解答
boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (char_set[val]) {
            return false;
        }
        char_set[val] = true;
    }
    return true;
}

//解説

/*
・最初に文字コードがASCIIかUnicodeかを聞く・・・基礎を知ってる感を演出：今回はASCII
・まず、128よりも文字列が大きければどこかしらで重複しているのでfalseを返す
・128個のboolean配列を用意する。
・例
str = javascriptの時、
j = true , a = true, v = trueと格納していき、
aが2回目に登場した際に、char_set['a'] = trueであるため、falseを返す。
という考え方。

計算量O(n)、消費メモリO(1)となる。for文は文字数128を超えることはないので計算量O(1)とすることもできる。
*/

//ビットベクトルを用いて消費メモリを8分の1に抑えることもできる。

//追加のデータ構造を使えない時どうするか

/*
１、全ての文字について他の文字と比較していく。O(n^2)の計算量、O(1)のメモリ消費
２、文字列をソートして、O(nlogn)、文字列の先頭から隣り合う２文字を比較していく。
これらの方法は問題の制約によっては有効となる。
*/


