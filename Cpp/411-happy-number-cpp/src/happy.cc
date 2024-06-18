#include "happy.h"

int happier(int num)
{
    int ans = 0;
    while (num != 0) {
        ans += (num % 10) * (num % 10);
        num /= 10;
    }
    return ans;
}

bool isHappy(int number)
{
    for (int i = 1; i <= 1000; i++) {
        if (number == 1) {
            return true;
        }
        number = happier(number);
    }
    return false;
}