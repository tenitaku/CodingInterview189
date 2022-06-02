//問題
/*
文字列に対して行うことができる三種類の編集：文字の挿入、文字の削除、文字の置き換え、があります。
２つの文字列が与えられた時、一方の文字列に対して１操作（もしくは操作なし）でもう一方にできるかどうかを判定してください。
(例)
pale , ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

//考えること
/*
・置き換え：bale pale ：異なる場所が１箇所しかない
・挿入：apple aple：１つシフトした文字が同じになる
・削除：一回削除の比較
*/

//解法
//削除と挿入を１つの関数にまとめる

boolean oneEditAway(String first, String second) {
    if (first.length() == second.length()) {
        return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
        return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
        return oneEditInsert(second, first);
    }
    return false;
}

boolean oneEditReplace(String s1, String s2) {
    boolean foundDifference = false;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            if (foundDifference) {
                return false;
            }
            foundDifference = true;
        }
    }
    return true;
}

boolean oneEditInsert(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    while (index2 < s2.length() && index1 < s1.length()) {
        if (s1.charAt(index1) != s2.charAt(index2)) {
            if (index1 != index2) {
                return false;
            }
            index2++;
        } else {
            index1++;
            index2++;
        }
    }
    return true;
}


