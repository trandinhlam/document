from PIL import Image
import numpy as np


def scale(test_images, test_path):
    images = []
    image_path = test_images
    for x in image_path:
        img = Image.open(test_path + '/' + x)
        img = img.resize((50, 50))
        img = np.array(img)
        images.append(img)
    images = np.array(images)
    images = images / 255
    return images
