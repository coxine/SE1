import unittest
from src import AdditionalExam


class TestAdditionalExam(unittest.TestCase):
	def setUp(self):
		pass

	def test1(self):
		expect = 14
		result = AdditionalExam.convert_roma_number_to_integer("XIV")
		self.assertEqual(expect, result)

	def test2(self):
		expect = "XIX"
		result = AdditionalExam.convert_integer_to_roma_number(19)
		self.assertEqual(expect, result)

	def tearDown(self):
		pass
