import os
from builtins import range

import pandas as pd

import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread
import seaborn as sns
from tensorflow import keras
from PIL import Image
import time

import visualization
from config import INPUT, TRAIN_PATH, TEST_PATH
from visualization import visualize
from find_mean_dimension import find_mean
from normalize_trained_data import normalize_data


##Các bước cần thực hiện cho bài toán classification
#visualization.visualize()
# find_mean()
# normalize_data()

from train_model import start_train
start_time = time.time()
start_train()
print("---> Execution time: %s seconds" % (time.time() - start_time))
# import tester
# tester.test()
# tester.single_test('./input/random.png')

