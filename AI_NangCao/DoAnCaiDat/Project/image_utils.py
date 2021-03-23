from PIL import Image
import numpy as np
from config import STANDARD_SIZE


def scale(test_images, test_path):
    images = []
    image_path = test_images
    for x in image_path:
        img = Image.open(test_path + '/' + x)
        img = img.resize(STANDARD_SIZE)
        img = np.array(img)
        images.append(img)
    images = np.array(images)
    images = images / 255
    return images
