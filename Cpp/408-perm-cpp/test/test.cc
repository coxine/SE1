#include <gtest/gtest.h>
#include "perm.h"

TEST(PERM, test1) {
  std::vector<int> input{1, 2, 3, 4, 5};
  std::vector<int> expect{1, 2, 3, 5, 4};

  NextPermutation(input);

  int size = input.size();
  bool correct = std::equal(input.begin(), input.begin() + size, expect.begin());

  EXPECT_TRUE(correct);
}

TEST(PERM, test5) {
  std::vector<int> input{3, 1, 2, 5, 4};
  std::vector<int> expect{3, 1, 4, 2, 5};

  NextPermutation(input);

  int size = input.size();
  bool correct = std::equal(input.begin(), input.begin() + size, expect.begin());

  EXPECT_TRUE(correct);
}

TEST(PERM, test10) {
  std::vector<int> input{3, 1, 2};
  std::vector<int> expect{3, 2, 1};

  NextPermutation(input);

  int size = input.size();
  bool correct = std::equal(input.begin(), input.begin() + size, expect.begin());

  EXPECT_TRUE(correct);
}

TEST(PERM, test15) {
  std::vector<int> input{4, 5, 3, 2, 1, 6};
  std::vector<int> expect{4, 5, 3, 2, 6, 1};

  NextPermutation(input);

  int size = input.size();
  bool correct = std::equal(input.begin(), input.begin() + size, expect.begin());

  EXPECT_TRUE(correct);
}

TEST(PERM, test20) {
  std::vector<int> input{8, 7, 6, 5, 4, 3, 1, 2};
  std::vector<int> expect{8, 7, 6, 5, 4, 3, 2, 1};

  NextPermutation(input);

  int size = input.size();
  bool correct = std::equal(input.begin(), input.begin() + size, expect.begin());

  EXPECT_TRUE(correct);
}