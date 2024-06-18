from unittest import TestCase

from src.thief import thief


class TestThief(TestCase):
    def test_something(self):
        self.assertEqual(1, thief([1]))

    def test_something1(self):
        self.assertEqual(0, thief([]))

    def test_something2(self):
        self.assertEqual(2, thief([1, 2]))

    def test_something3(self):
        self.assertEqual(2, thief([2, 1]))

    def test_something4(self):
        self.assertEqual(4, thief([3, 2, 1]))

    def test_something5(self):
        self.assertEqual(16, thief([6, 2, 1, 6, 9, 4]))

    def test_something6(self):
        self.assertEqual(16, thief([2, 6, 1, 6, 9, 4]))


