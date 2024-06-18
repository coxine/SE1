import unittest
import sys
from src import josephus


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(josephus.get_num(6, 3), 1)

    def test2(self):
        self.assertEqual(josephus.get_num(3, 3), 2)

    def test3(self):
        self.assertEqual(josephus.get_num(9, 6), 7)

    def tearDown(self):
        pass


