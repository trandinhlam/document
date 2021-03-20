import os

import matplotlib.pyplot as plt
from matplotlib.image import imread
from config import INPUT, TRAIN_PATH, TEST_PATH
import random


def visualize():
    images_path = os.listdir(TEST_PATH)
    plt.figure(figsize=(25, 25))
    for i in range(1, 26):
        plt.subplot(5, 5, i)
        random_img_path = TEST_PATH + '/' + random.choice(images_path)
        ran_img = imread(random_img_path)
        plt.imshow(ran_img)
        plt.xlabel(ran_img.shape[1], fontsize=20)
        plt.ylabel(ran_img.shape[0], fontsize=20)
    plt.show()
