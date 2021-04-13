import os

import pandas as pd
from PIL import Image
from tensorflow import keras
from matplotlib import pyplot as plt
import numpy as np
from config import TEST_PATH, STANDARD_SIZE, MODEL_PATH


def test():
    model = keras.models.load_model(MODEL_PATH)
    # Test trên tập test ban đầu
    test_img = sorted(os.listdir(TEST_PATH))
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
    model = keras.models.load_model(MODEL_PATH)
    img = Image.open(image_path)
    print(np.array(img).shape)
    img = img.resize(STANDARD_SIZE)
    img = np.array(img)
    images = np.array([img])
    images = images / 255
    print(image_path, ': ', model.predict_classes(images))
    plt.figure(figsize=(100, 100))
    # plt.subplots(2)
    plt.title(model.predict_classes(images))
    plt.imshow(img)
    plt.show()


plt.show()

# test()
single_test('./input/online/1.png')
single_test('./input/online/2.png')
single_test('./input/online/3.png')
single_test('./input/online/4.png')
single_test('./input/online/5.png')
single_test('./input/online/6.png')
