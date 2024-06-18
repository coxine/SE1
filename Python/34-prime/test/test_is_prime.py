import unittest
import sys
from src import prime


class Test(unittest.TestCase):

    def setUp(self):
        pass

    def test1(self):
        self.assertEqual(prime.is_prime(3), True)

    def test2(self):
         self.assertEqual(prime.is_prime(20), False)
    
    def test3(self):
        self.assertEqual(prime.is_prime(50), False)
        
    def tearDown(self):
        pass


