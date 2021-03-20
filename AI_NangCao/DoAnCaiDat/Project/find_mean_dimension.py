import os
from builtins import range

import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread
import seaborn as sns
from config import TRAIN_PATH


def find_mean():
    dim1 = []
    dim2 = []
    for i in range(0, 43):
        labels = TRAIN_PATH + '/{0}'.format(i)
        img_path = os.listdir(labels)
        for x in img_path:
            img = imread(labels + '/' + x)
            dim1.append(img.shape[0])
            dim2.append(img.shape[1])
    sns.jointplot(dim1, dim2)
    plt.show()
    plt.savefig('wid_height_stats.png')
    print(np.mean(dim1))  ##will print: 50.328929582493814
    print(np.mean(dim2))  ## will print: 50.83587951745773
