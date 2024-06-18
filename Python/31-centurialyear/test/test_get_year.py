import unittest
import sys
from src import centurial_year


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(centurial_year.get_year(2013), False)

    def test2(self):
        self.assertEqual(centurial_year.get_year(400), True)

    def test3(self):
        self.assertEqual(centurial_year.get_year(100), False)



    def tearDown(self):
        pass


