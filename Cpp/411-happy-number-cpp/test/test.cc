#include <gtest/gtest.h>
#include "happy.h"

TEST(HAPPYTEST, test1)
{
  EXPECT_EQ(true, isHappy(19));
}

TEST(HAPPYTEST, test2)
{
  EXPECT_EQ(false, isHappy(25));
}

TEST(HAPPYTEST, test3)
{
  EXPECT_EQ(true, isHappy(100));
}

TEST(HAPPYTEST, test4)
{
  EXPECT_EQ(false, isHappy(1234));
}

TEST(HAPPYTEST, test5)
{
  EXPECT_EQ(true, isHappy(368));
}