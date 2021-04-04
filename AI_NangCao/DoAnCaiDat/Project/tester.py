import os

import pandas as pd
from PIL import Image
from tensorflow import keras
import numpy as np
from config import TEST_PATH, STANDARD_SIZE, INPUT, SLASH


def test():
    model = keras.models.load_model('model' + SLASH + 'tdlam_Model_1st.h5')
    # Test trên tập test ban đầu
    test_img = sorted(os.listdir(TEST_PATH))
    import image_utils
    from sklearn.metrics import classification_report

    test_images = image_utils.scale(test_img, test_path=TEST_PATH)
    test = pd.read_csv(INPUT + SLASH + 'Test.csv')
    y_test = test['ClassId'].values
    print(y_test)
    y_pred = model.predict_classes(test_images)
    print(y_pred)
    print(classification_report(y_test, y_pred))


def single_test(image_path):
    model = keras.models.load_model('model' + SLASH + 'tdlam_Model_1st.h5')
    img = Image.open(image_path)
    print(np.array(img).shape)
    img = img.resize(STANDARD_SIZE)
    img = np.array(img)
    images = np.array([img])
    images = images / 255
    print(model.predict_classes(images))


test()
single_test('./input/random.png')
single_test('./input/out.png')
