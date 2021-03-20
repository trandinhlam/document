import os
from builtins import range

import pandas as pd

import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread
import seaborn as sns
from config import INPUT, TRAIN_PATH, TEST_PATH
from visualization import visualize
from find_mean_dimension import find_mean
from nomalize_trained_data import nomalize_data

# visualization.visualize()
# find_mean()
# nomalize_data()

# chia tập train đã chuẩn hóa thành 2 tập train và test
images = np.load('./numpy/standard_training.npy')
labels = np.load('./numpy/labels.npy')

from sklearn.model_selection import train_test_split

x_train, x_val, y_train, y_val = train_test_split(images, labels, test_size=0.2, random_state=42)

# one-hot encoding
from tensorflow.keras.utils import to_categorical

y_train_cat = to_categorical(y_train)
y_val_cat = to_categorical(y_val)

print(y_train_cat.shape)
print(y_val_cat.shape)

# model building
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Flatten, Dropout, Conv2D, MaxPool2D

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

#layer flatten
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

#start train
model.fit(x=x_train, y=y_train,
          epochs=25,
          batch_size=64,
          validation_data=(x_val, y_val),
          callbacks=[early_stopping],
          verbose=2
          )
model.save('Model.h5')
