import unittest
import sys
from src import fibonacci


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(fibonacci.get_num(3), 2)

    def test2(self):
         self.assertEqual(fibonacci.get_num(4), 3)

    def test3(self):
        self.assertEqual(fibonacci.get_num(5), 5)
    def tearDown(self):
        pass


