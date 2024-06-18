import unittest
import sys
from src import pizza_cal


class TestCalc(unittest.TestCase):

    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_one(self):
        self.stream_in.write('10')
        self.stream_in.write('2')
        self.stream_in.write('8')
        pizza_cal.pizza_calculation()
        expect = ('Each people gets 1 pieces of pizza' + '\n' +
                  '6 leftover pieces'+'\n')
        result = ''
        for i in range(3, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_two(self):
        self.stream_in.write('8')
        self.stream_in.write('2')
        self.stream_in.write('8')
        pizza_cal.pizza_calculation()
        expect = ('Each people gets 2 pieces of pizza' + '\n' +
                  '0 leftover pieces' + '\n')
        result = ''
        for i in range(3, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_three(self):
        self.stream_in.write('50')
        self.stream_in.write('5')
        self.stream_in.write('12')
        pizza_cal.pizza_calculation()
        expect = ('Each people gets 1 pieces of pizza' + '\n' +
                  '10 leftover pieces' + '\n')
        result = ''
        for i in range(3, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_four(self):
        self.stream_in.write('4')
        self.stream_in.write('4')
        self.stream_in.write('8')
        pizza_cal.pizza_calculation()
        expect = ('Each people gets 8 pieces of pizza' + '\n' +
                  '0 leftover pieces' + '\n')
        result = ''
        for i in range(3, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass


class MyStream:

    def __init__(self):
        self.buff = []
        self.write_count = 0

    def write(self, output_stream):
        self.buff.append(output_stream)
        if len(self.buff) > 1000:
            sys.exit("Too many outputs, error! There may be an endless loop in your code!")

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur