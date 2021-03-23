import os
from builtins import range
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np
from config import TRAIN_PATH, STANDARD_SIZE
from PIL import Image


def normalize_data():
    images = []
    labels = []
    for i in range(43):
        folder = TRAIN_PATH + '/{0}'.format(i)
        image_path = os.listdir(folder)
        for item in image_path:
            img = Image.open(folder + '/' + item)
            img = img.resize(STANDARD_SIZE)
            img = np.array(img)
            images.append(img)
            labels.append(i)

    print(len(images))  ##39209
    print(len(labels))  ##39209
    # xem phân bổ hình của từng nhãn từ 0 đến 42
    plt.figure(figsize=(15, 5))
    sns.countplot(labels)
    plt.xlabel("Label", fontsize=12)
    plt.show()
    images = np.array(images)
    images = images / 255

    np.save('numpy/standard_training', images)
    np.save('numpy/labels', labels)
    return images, labels
