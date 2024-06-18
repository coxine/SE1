import unittest
import sys
import os
from src import word_count


class Testwordcount(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_word_count_one(self):
        word_count.wordcount("./test1")  # 本地测试使用
        # word_count.wordcount('./test/test1')
        expect = (
            "Elizabeth: *******"
            + os.linesep
            + "Linda:     *****"
            + os.linesep
            + "Barbara:   ****"
            + os.linesep
            + "Mary:      ****"
            + os.linesep
            + "Patricia:  ****"
            + os.linesep
        )
        result = ""
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_word_count_two(self):
        word_count.wordcount("./test2")  # 本地测试使用
        # word_count.wordcount("./test/test2")
        expect = (
            "Elizabeth: ********"
            + os.linesep
            + "Barbara:   *****"
            + os.linesep
            + "Mary:      *****"
            + os.linesep
            + "Patricia:  *****"
            + os.linesep
            + "Linda:     *"
            + os.linesep
        )
        result = ""
        for i in range(0, len(self.stream_out.buff)):
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

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur


if __name__ == "__main__":
    unittest.main
