from unittest import TestCase
import hello_world


class TestHelloWorld(TestCase):
    def test_hello_world(self):
        self.assertEqual(hello_world.hello_world(self),"Hello World")
