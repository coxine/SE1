import unittest
from src import legal_age
import sys


class TestCurrency(unittest.TestCase):
    """test legal driving age"""

    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_age1(self):
        age = '-1'
        self.stream_in.write(age)
        legal_age.legal_driving_age()
        result = self.stream_out.buff[1]
        self.assertEqual(result, "Please enter a natural number.")

    def test_age2(self):
        age = '15'
        self.stream_in.write(age)
        legal_age.legal_driving_age()
        result = self.stream_out.buff[1]
        self.assertEqual(result, "You are not old enough to legally drive.")

    def test_age3(self):
        age = '42'
        self.stream_in.write(age)
        legal_age.legal_driving_age()
        result = self.stream_out.buff[1]
        self.assertEqual(result, "You are old enough to legally drive.")

    def test_age4(self):
        age = '200'
        self.stream_in.write(age)
        legal_age.legal_driving_age()
        result = self.stream_out.buff[1]
        self.assertEqual(result, "You are old enough to legally drive.")

    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass


class MyStream:

    def __init__(self):
        self.buff = []

    def write(self, output_stream):
        self.buff.append(output_stream)

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur
