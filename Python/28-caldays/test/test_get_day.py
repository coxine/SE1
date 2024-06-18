import unittest
import sys
from src import cal_day


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
    	self.assertEqual(cal_day.get_day(3, 5), 1)

    def test2(self):
    	self.assertEqual(cal_day.get_day(4, 1), 28)

    def test3(self):
    	self.assertEqual(cal_day.get_day(6, 1), 89)



    def tearDown(self):
        pass


