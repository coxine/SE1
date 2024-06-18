#include <gtest/gtest.h>
#include "repeat.h"

TEST(REPEAT, test1) {
  EXPECT_EQ(true, repeatedSubstringPattern("abab"));
}

TEST(REPEAT, test2) {
  EXPECT_EQ(true, repeatedSubstringPattern("abcabcabc"));
}

TEST(REPEAT, test3) {
  EXPECT_EQ(true, repeatedSubstringPattern("aaaaa"));
}

TEST(REPEAT, test4) {
  EXPECT_EQ(false, repeatedSubstringPattern("abcd"));
}

TEST(REPEAT, test5) {
  EXPECT_EQ(true, repeatedSubstringPattern("abcdeabcde"));
}