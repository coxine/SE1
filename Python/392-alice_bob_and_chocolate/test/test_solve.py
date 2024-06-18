import unittest
from src import Alice_Bob_and_Chocolate
import sys

class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertListEqual(Alice_Bob_and_Chocolate.solve(5, [2, 9, 8, 2, 7]), [2, 3])

    def test2(self):
        self.assertListEqual(Alice_Bob_and_Chocolate.solve(5, [29, 13, 7, 26, 18]), [3, 2])

    def test3(self):
        self.assertListEqual(Alice_Bob_and_Chocolate.solve(4, [3, 6, 4, 4]), [2, 2])     
