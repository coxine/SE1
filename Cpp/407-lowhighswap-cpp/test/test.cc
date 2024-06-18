#include <gtest/gtest.h>
#include "low_high_swap.h"

TEST(LOWHIGHSWAPTEST, test1) {
  vector<int> array = {5,4,3,2,1};
  string expect = "12345";
  EXPECT_EQ(expect, low_high_swap(array));
}

TEST(LOWHIGHSWAPTEST, test2) {
  vector<int> array = {1,3,4,6,2,1};
  string expect = "124631";
  EXPECT_EQ(expect, low_high_swap(array));
}

TEST(LOWHIGHSWAPTEST, test3) {
  vector<int> array = {8,7,6,5,4,3,2,1};
  string expect = "12345678";
  EXPECT_EQ(expect, low_high_swap(array));
}