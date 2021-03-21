import os
from builtins import range
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread
import seaborn as sns
from tensorflow import keras
from PIL import Image
import tensorflow as tf
from tensorflow.keras.layers import Dense, Flatten, Dropout, Conv2D, MaxPool2D
from tensorflow.keras.models import Sequential
from sklearn.model_selection import train_test_split
from tensorflow.keras.utils import to_categorical
from google.colab import drive

drive.mount('/content/drive')

FOLDER = '/content/drive/MyDrive/Colab Notebooks/'
INPUT = FOLDER + '/input'
TRAIN_PATH = INPUT + '/Train'
TEST_PATH = INPUT + '/Test'
print(INPUT)
print(os.listdir(INPUT))


# nomarlize train data
def normalize_data():
    standard = (50, 50)
    images = []
    labels = []
    for i in range(43):
        folder = TRAIN_PATH + '/{0}'.format(i)
        image_path = os.listdir(folder)
        for item in image_path:
            img = Image.open(folder + '/' + item)
            img = img.resize(standard)
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
    return images, labels


def start_train():
    # chia tập train đã chuẩn hóa thành 2 tập train và test
    labels = np.load(FOLDER + '/numpy/labels.npy')
    images = np.load(FOLDER + '/numpy/standard_training.npy')

    x_train, x_val, y_train, y_val = train_test_split(images, labels, test_size=0.1, random_state=42)
    # one-hot encoding
    y_train_cat = to_categorical(y_train)
    y_val_cat = to_categorical(y_val)
    print(y_train_cat.shape)
    print(y_val_cat.shape)
    # model building
    model = Sequential()
    # layer 1
    model.add(
        Conv2D(filters=64, kernel_size=(3, 3),
               input_shape=x_train.shape[1:],
               activation='relu', padding='same')
    )
    model.add(MaxPool2D(pool_size=(2, 2)))
    model.add(Dropout(0.5))
    # layer 2
    model.add(Conv2D(filters=64, kernel_size=(3, 3), activation='relu'))
    model.add(MaxPool2D(pool_size=(2, 2)))
    model.add(Dropout(0.5))
    # layer 3
    model.add(Conv2D(filters=64, kernel_size=(3, 3), activation='relu'))
    model.add(MaxPool2D(pool_size=(2, 2)))
    model.add(Dropout(0.5))
    # layer flatten
    model.add(Flatten())
    # Dense layer
    model.add(Dense(128, activation='relu'))
    model.add(Dropout(0.5))
    # output layer
    model.add(Dense(43, activation='softmax'))
    # loss
    model.compile(loss='sparse_categorical_crossentropy',
                  optimizer='adam',
                  metrics=['accuracy'])

    print(model.summary())

    early_stopping = tf.keras.callbacks.EarlyStopping(monitor='val_loss', patience=2)
    # start train
    model.fit(x=x_train, y=y_train,
              epochs=50,
              batch_size=64,
              validation_data=(x_val, y_val),
              callbacks=[early_stopping],
              verbose=2
              )
    model.save(INPUT + '/../tdlam_Model_3rd.h5')
    # Đánh giá kết quả train
    evaluation = pd.DataFrame(model.history.history)
    plot1 = evaluation[['accuracy', 'val_accuracy']].plot()
    plot2 = evaluation[['loss', 'val_loss']].plot()


start_train()
