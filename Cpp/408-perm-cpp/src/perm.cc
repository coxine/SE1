#include "perm.h"

void NextPermutation(std::vector<int> &perm)
{
    int i = perm.size() - 2;
    while (i >= 0 && perm[i] >= perm[i + 1]) {
        i--;
    }
    if (i >= 0) {
        int j = perm.size() - 1;
        while (j >= 0 && perm[j] <= perm[i]) {
            j--;
        }
        std::swap(perm[i], perm[j]);
    }
    std::reverse(perm.begin() + i + 1, perm.end());
}