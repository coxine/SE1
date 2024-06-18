import unittest
import sys
from src import special_typing


class TestCalc(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass



    def test1(self):
        self.stream_in.write('4')
        self.stream_in.write('ababa')
        self.stream_in.write('ba')
        self.stream_in.write('ababa')
        self.stream_in.write('bb')
        self.stream_in.write('aaa')
        self.stream_in.write('aaaa')
        self.stream_in.write('aababa')
        self.stream_in.write('ababa')
        expect = 'YES\n' + 'NO\n' + 'NO\n' + 'YES\n'
        special_typing.special_typing()
        result = ''
        for i in range(len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test2(self):
        self.stream_in.write('2')
        self.stream_in.write('lrlrrlrllrlrlrllllrlrllrl')
        self.stream_in.write('llrlrl')
        self.stream_in.write('xyxyxyyxyxyyyxyxyx')
        self.stream_in.write('xxy')
        expect = 'YES\n' + 'NO\n'
        special_typing.special_typing()
        result = ''
        for i in range(len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test3(self):
        self.stream_in.write('1')
        self.stream_in.write('sdfxcvxcsdfdsfs')
        self.stream_in.write('a')
        expect = 'NO\n'
        special_typing.special_typing()
        result = ''
        for i in range(len(self.stream_out.buff)):
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
        if len(self.buff) > 10000:
            sys.exit("Too many outputs, error! There may be an endless loop in your code!")

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur
        return ''
