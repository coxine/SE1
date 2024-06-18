#include "low_high_swap.h"
using namespace std;

string vec_to_string(vector<int> array)
{
    string s = "";
    for (int i = 0; i < array.size(); i++) {
        s += to_string(array[i]);
    }
    return s;
}

string low_high_swap(vector<int> array)
{
    int len = array.size();
    for (int i = 0, j = len - 1; i < j; i++, j--) {
        if (array[i] > array[j]) {
            swap(array[i], array[j]);
        }
    }
    return vec_to_string(array);
}