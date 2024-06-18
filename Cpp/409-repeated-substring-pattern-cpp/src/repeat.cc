
#include "repeat.h"

bool checkStr(string str, string sub)
{
    if (str.length() % sub.length() != 0) {
        return false;
    }
    for (int i = 0; i < str.length(); i++) {
        if (str[i] != sub[i % sub.length()]) {
            return false;
        }
    }
    return true;
}

bool repeatedSubstringPattern(string s)
{
    for (int i = 1; i < s.length(); i++) {
        string sub = s.substr(0, i);
        if (checkStr(s, sub)) {
            return true;
        }
    }
    return false;
}