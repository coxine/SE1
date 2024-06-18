#! /usr/bin/env python
# -*- coding: utf-8 -*-

import time


def calculate():
    curAge = input("What is your current age?")
    retireAge = input("At what age would you like to retire?")
    workingYear = int(retireAge) - int(curAge)
    remainYear = max(workingYear, 0)
    nowYear = time.gmtime(time.time()).tm_year
    retireYear = nowYear + workingYear
    print("You have {0} years left until you can retire.".format(remainYear))
    print("It's {0}, so you can retire in {1}.".format(nowYear, retireYear))
