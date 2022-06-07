//問題
/*
片方の文字列が、もう片方の文字列の一部になっているかどうかを調べるメソッド「isSubstring」が使えると仮定します。
２つの文字列s1とs2が与えられた時に、isSubstringメソッドを一度だけ使ってs2がs1を回転させたものかどうかを判定するコードを書いてください。
例：waterbottleはerbottlewatを回転させたもの。
*/

//解法
/*
①どこで区切ろうとs2はs1s1の部分文字列である。ということを利用する
例：s1=erbottlewat s2 = waterbottleの時、
waterbottle は　erbottlewaterbottlewat　の部分文字列
これだけ。
*/

bool isRotation(String s1, String s2) {
    int len = s1.length();
    if (s1.length() > 0 && len == s2.length()) {
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
    return false;
}