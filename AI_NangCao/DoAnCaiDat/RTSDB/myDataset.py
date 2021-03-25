import os
import numpy as np
import pandas as pd
from glob import glob
import cv2
import torch
from numpy import short
from torch.utils import data
from PIL import Image
import torchvision
from torchvision import transforms
import matplotlib.pyplot as plt

from config import PATH_TRAIN


class MyDataset(data.Dataset):
    def __init__(self, image_dic, transform=None):
        self.imgs = list(sorted(os.listdir(PATH_TRAIN)))
        self.image_dic = image_dic
        self.transform = transform

    def __getitem__(self, index):
        img_name = self.imgs[index]
        img_path = PATH_TRAIN + '/' + img_name
        img = Image.open(img_path).convert("RGB")
        objects = self.image_dic[img_name]
        boxes = []
        labels = []
        for obj in objects:
            name = obj[-1]
            labels.append(np.int(name))
            # Get bounding box coordinates
            xmin = np.float(obj[0])
            ymin = np.float(obj[1])
            xmax = np.float(obj[2])
            ymax = np.float(obj[3])
            boxes.append([xmin, ymin, xmax, ymax])

        boxes = torch.as_tensor(boxes, dtype=torch.float32)
        labels = torch.as_tensor(labels, dtype=torch.int64)
        info = {}
        info['boxes'] = boxes
        info['labels'] = labels
        info['id'] = torch.tensor([index])
        info['area'] = (boxes[:, 3] - boxes[:, 1]) * (boxes[:, 2] - boxes[:, 0])

        if self.transform is not None:
            # Note that target (including bbox) is also transformed\enhanced here, which is different from transforms from torchvision import
            # Https://github.com/pytorch/vision/tree/master/references/detectionOfTransforms.pyThere are examples of target transformations when RandomHorizontalFlip
            img, info = self.transform(img, info)

        return img, info

    def __len__(self):
        return len(self.imgs)
