//問題
/*
文字の連続する数を使って基本的な文字列圧縮を行うメソッドを実装してください。例えば、aabccccaaaはa2b1c5a3のようにしてください。
大文字と小文字は区別します。
*/

//解法：文字列を走査して新しい文字列にコピーしながら現在の文字が次の文字と同じかどうかを判定する。

String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
        countConsecutive++;
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
}