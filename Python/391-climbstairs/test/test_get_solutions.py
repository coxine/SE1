import unittest
import sys
from src import climbStairs


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(climbStairs.get_solutions(1), 1)

    def test2(self):
         self.assertEqual(climbStairs.get_solutions(2), 2)

    def test3(self):
        self.assertEqual(climbStairs.get_solutions(3), 3)
    def tearDown(self):
        pass


