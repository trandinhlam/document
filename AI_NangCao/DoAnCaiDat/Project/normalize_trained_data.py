import os
from builtins import range
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np
from config import TRAIN_PATH, STANDARD_SIZE, SLASH, NUMPY_OUTPUT
from PIL import Image


def normalize_data():
    images = []
    labels = []
    for i in range(43):
        folder = TRAIN_PATH + SLASH + '{:02d}'.format(i)
        image_path = os.listdir(folder)
        for item in image_path:
            img = Image.open(folder + SLASH + item)
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

    np.save(NUMPY_OUTPUT + SLASH + 'standard_training', images)
    np.save(NUMPY_OUTPUT + SLASH + 'labels', labels)
    return images, labels
