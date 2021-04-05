import os

import pandas as pd
from PIL import Image
from tensorflow import keras
import numpy as np
from config import TEST_PATH, STANDARD_SIZE, MODEL_PATH


# Test trên tập test ban đầu, có lọc ra tập test là loại con cụ thể trong 6 loại để so sánh
def test_subclass():
    model = keras.models.load_model(MODEL_PATH)
    test_img = sorted(os.listdir(TEST_PATH))
    # todo filter các hình thuộc loại cần để test
    import image_utils
    from sklearn.metrics import classification_report

    test_images = image_utils.scale(test_img, test_path=TEST_PATH)
    test = pd.read_csv('./input/Test.csv')
    y_test = test['ClassId'].values
    # todo filter các hình thuộc loại cần để test
    print(y_test)
    y_pred = model.predict_classes(test_images)
    print(y_pred)
    print(classification_report(y_test, y_pred))
