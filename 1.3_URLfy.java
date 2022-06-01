
//問題
/*
文字列内に出現する全ての空白文字を"%20"で置き換えるメソッドを書いてください。
ただし、文字列の後ろには新たに文字を追加するためのスペースが十分にある（バッファのサイズは気にしなくても良い）ことと、
その追加用スペースを除いた文字列の真の長さが与えられます。
(例)
入力："Mr John Smith ", 13
出力："Mr%20John%20Smith"
*/

//解法
/*
2回走査する方法を用いる。
最初の走査では、空白文字の数を数える。この数を三倍することで、最後の文字列に追加する文字の数を計算できる。
逆の順序で行われる2回目の走査では、実際に文字列を置き換える。空白文字を%20で置き換える。空白でない時は元の文字をコピーする。
*/

void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0;
    int index; 
    int i = 0;
    for (i = 0; i < trueLength; i++) {
        if (str[i] == ' ') {
            spaceCount++;
        }
    }
    index = trueLength + spaceCount * 2;

    if (trueLength < str.length()) str[trueLength] = '\0';
    for (i = trueLength - 1; i >= 0; i--) {
        if (str[i] == ' ') {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';
            index = index - 3;
        } else {
            str[index - 1] = str[i];
            index--;
        }
    }
}



