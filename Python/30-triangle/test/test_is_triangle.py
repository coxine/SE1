import unittest
import sys
from src import triangle


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(triangle.is_triangle(1, 1, 1), True)

    def test2(self):
         self.assertEqual(triangle.is_triangle(4, 5, 3), True)

    def test3(self):
        self.assertEqual(triangle.is_triangle(1, 1, 3), False)

    def tearDown(self):
        pass


