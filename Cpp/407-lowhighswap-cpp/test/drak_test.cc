#include <gtest/gtest.h>
#include "low_high_swap.h"

TEST(LOWHIGHSWAPTEST, test4) {
  vector<int> array = {1,2,3,4,5};
  string expect = "12345";
  EXPECT_EQ(expect, low_high_swap(array));
}

TEST(LOWHIGHSWAPTEST, test5) {
  vector<int> array = {10,6,7,8,4,3,1,2,5,9};
  string expect = "95213487610";
  EXPECT_EQ(expect, low_high_swap(array));
}

TEST(LOWHIGHSWAPTEST, test6) {
  vector<int> array = {5};
  string expect = "5";
  EXPECT_EQ(expect, low_high_swap(array));
}