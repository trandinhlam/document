import numpy as numpy
import sys
from sklearn import metrics


def getLabelsPred(startpts, points, k):
    labelsPred = [-1] * len(points)

    for i in range(len(points)):
        distances = numpy.linalg.norm(points[i] - startpts, axis=1)
        labelsPred[i] = numpy.argmin(distances)

    return labelsPred


def DB(startpts, points, k):
    labelsPred = getLabelsPred(startpts, points, k)
    if numpy.unique(labelsPred).size < k:
        fitness = sys.float_info.max
    else:
        fitness = metrics.davies_bouldin_score(points, labelsPred)
    return fitness, labelsPred
