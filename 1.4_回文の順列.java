//問題
/*
文字列が与えられた時、その文字列が回文の順列であるかを調べる関数を書いてください。順列とは、文字を並び替えたもの。
(例)
入力："Tact Coa"
出力："True" taco cat, atco cta など
*/

//解法
/*
ほぼ全ての文字の数が偶数個、１つだけ奇数個となれば良い。
偶数個の文字列は、全ての文字が偶数回、
奇数個の文字列は、１つ奇数個の文字を含む必要がある。
*/

//解法１
//ハッシュテーブルを使用し、各文字が何回出現するかを数える。
//その後ハッシュテーブルを走査し、奇数個の文字が複数個存在しないことを確認する。

boolean isPermutationOfPalindrome(String phrase) {
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
}

boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count : table) {
        if (count % 2 == 1) {
            if (foundOdd) {
                return false;
            }
            //一回の奇数まではOK
            foundOdd = true;
        }
    }
    return true;
}

//文字を数字に割り当てる。大文字小文字の区別はなし。文字でなければ-1を返す。
int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
        return val - a;
    }
    return -1;
}

int[] buildCharFrequencyTable(String phrase) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
        int x = getCharNumber(c);
        if (x != -1) {
            table[x]++;
        }
    }
    return table;
}

//解法２
boolean isPermutationOfPalindrome(String phrase) {
    int countOdd = 0;
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : phrase.toCharArray()) {
        int x = getCharNumber(c);
        if (x != -1) {
            table[x]++;
            if (table[x] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
    }
    return countOdd <= 1;
}

//解法３ ビットベクトルの使用（高難度）



