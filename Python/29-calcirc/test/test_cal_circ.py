import unittest
import sys
from src import cal_circ


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(cal_circ.get_circ(1), 6)

    def test2(self):
        self.assertEqual(cal_circ.get_circ(2), 12)

    def test3(self):
        self.assertEqual(cal_circ.get_circ(3), 18)



    def tearDown(self):
        pass


