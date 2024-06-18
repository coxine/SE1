import unittest
import sys
from src import factorial


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(factorial.count_zeros(10), 2)

    def test2(self):
         self.assertEqual(factorial.count_zeros(5), 1)

    def test3(self):
        self.assertEqual(factorial.count_zeros(51), 12)
    def tearDown(self):
        pass


