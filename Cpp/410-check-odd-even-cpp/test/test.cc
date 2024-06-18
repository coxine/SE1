#include <gtest/gtest.h>
#include "check_odd_even.h"

TEST(CHECK_ODD_EVEN, testSingle1) {
  EXPECT_EQ(false, isOdd(0));
}

TEST(CHECK_ODD_EVEN, testSingle2) {
  EXPECT_EQ(true, isOdd(3));
}

TEST(CHECK_ODD_EVEN, testSingle3) {
  EXPECT_EQ(false, isOdd(12));
}