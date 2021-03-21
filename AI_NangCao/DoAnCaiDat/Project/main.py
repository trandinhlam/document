import os
from builtins import range

import pandas as pd

import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread
import seaborn as sns
from tensorflow import keras

from config import INPUT, TRAIN_PATH, TEST_PATH
from visualization import visualize
from find_mean_dimension import find_mean
from normalize_trained_data import normalize_data
from train_model import start_train
from PIL import Image


##Các bước cần thực hiện nhu sau
# visualization.visualize()
# find_mean()
# normalize_data()
# start_train()


def test():
    model = keras.models.load_model('./Model.h5')
    # Test trên tập test ban đầu
    test_img = sorted(os.listdir(TEST_PATH))
    from PIL import Image
    import image_utils
    from sklearn.metrics import classification_report

    test_images = image_utils.scale(test_img, test_path=TEST_PATH)
    test = pd.read_csv('./input/Test.csv')
    y_test = test['ClassId'].values
    print(y_test)
    y_pred = model.predict_classes(test_images)
    print(y_pred)
    print(classification_report(y_test, y_pred))


def single_test(image_path):
    model = keras.models.load_model('./Model.h5')
    img = Image.open(image_path,)
    print(np.array(img).shape)
    img = img.resize((50, 50))
    img = np.array(img)
    images = np.array([img])
    images = images / 255
    print(model.predict_classes(images))


test()
# single_test('./input/random.png')
# single_test('./input/out.png')
