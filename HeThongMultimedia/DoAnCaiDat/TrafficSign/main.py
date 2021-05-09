import numpy as np  # linear algebra
import pandas as pd  # data processing, CSV file I/O (e.g. pd.read_csv)
import cv2
import time
from timeit import default_timer as timer
import matplotlib.pyplot as plt
import pickle

from keras.models import load_model
import random
from PIL import Image
import math

# Parsing markings dataset
path_prefix = "/root/darknet/rmarkings"
validate_percentage = 0.2


def RepresentsInt(s):
    try:
        int(s)
        return True
    except ValueError:
        return False


def parse():
    train = {}
    validate = {}
    cls_labels = {}

    # Read data
    with open('dataset_annotations.txt') as file:
        classes = {}
        for line in file.readlines():
            lines = line.strip().split(",")
            file_name, clas_spec = lines[-1], lines[-2]
            file_name = file_name.replace(".png", ".jpg")

            xs = [int(float(lines[0])), int(float(lines[2])), int(float(lines[4])), int(float(lines[6]))]
            ys = [int(float(lines[1])), int(float(lines[3])), int(float(lines[5])), int(float(lines[7]))]

            x_min, x_max = min(xs), max(xs)
            y_min, y_max = min(ys), max(ys)

            width = x_max - x_min
            height = y_max - y_min

            im = Image.open(file_name)
            im_width, im_height = im.size

            center_x, center_y = (width / 2) + x_min, (height / 2) + y_min

            if classes.get(clas_spec) is None:
                classes[clas_spec] = []
            data = {"name": file_name, "x": center_x / im_width, "y": center_y / im_height, "width": width / im_width,
                    "height": height / im_height}
            classes[clas_spec].append(data)
            print(data)

        it = 0
        for key, values in classes.items():
            if len(values) > 20 and not RepresentsInt(key):
                cls_labels[it] = key
                random.shuffle(values)
                test_len = math.floor(len(values) * validate_percentage)
                train[key] = values[-(len(values) - test_len):]
                validate[key] = values[:test_len]

                print(f"validate: {key}: {len(validate[key])}")
                print(f"train: {key}: {len(train[key])}")

                for value in values:
                    f_name = value["name"].replace(".jpg", ".txt")
                    with open(f_name, "w+") as w_file:
                        w_file.write(f"{it} {value['x']} {value['y']} {value['width']} {value['height']}\n")
                it += 1

    with open("classes.names", "w+") as cls_file:
        for cls_name in cls_labels.values():
            cls_file.write(f"{cls_name}\n")

    with open("train.txt", "w+") as data_file:
        for vls in train.values():
            for val in vls:
                data_file.write(f"{path_prefix}/{val['name']}\n")

    with open("test.txt", "w+") as data_file:
        for vls in validate.values():
            for val in vls:
                data_file.write(f"{path_prefix}/{val['name']}\n")

    with open("data.data", "w+") as data_file:
        data_file.write(f"""classes = {len(cls_labels.keys())}
train = {path_prefix}/train.txt
valid = {path_prefix}/test.txt
names = {path_prefix}/classes.names
backup = backup1""")
