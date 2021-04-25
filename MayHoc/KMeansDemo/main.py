from __future__ import print_function
import numpy as np
import matplotlib.pyplot as plt
from scipy.spatial.distance import cdist

np.random.seed(11)

means = [[2, 2], [8, 3], [3, 6], [5, 5]]
cov = [[1, 0], [0, 1]]

N = 200
X0 = np.random.multivariate_normal(means[0], cov, N)
X1 = np.random.multivariate_normal(means[1], cov, N)
X2 = np.random.multivariate_normal(means[2], cov, N)
X3 = np.random.multivariate_normal(means[3], cov, N)

X = np.concatenate((X0, X1, X2, X3), axis=0)
print(X.shape)
K = 4

original_label = np.asarray([0] * N + [1] * N + [2] * N + [3] * N).T


def kmeans_display_center(X, label, centers):
    K = np.amax(label) + 1
    colors = np.array(['b^', 'go', 'rs', 'yo']).T
    for k in range(0, K - 1):
        Xi = X[label == k, :]
        plt.plot(Xi[:, 0], Xi[:, 1], colors[k], markersize=4, alpha=.8)
        plt.plot(centers[k, 0], centers[k, 1], colors[K-1-k], markersize=10, alpha=.8)

    plt.axis('equal')
    plt.plot()
    plt.show()


def kmeans_display(X, label):
    K = np.amax(label) + 1
    colors = np.array(['b^', 'go', 'rs', 'yo']).T
    for k in range(0, K - 1):
        Xi = X[label == k, :]
        plt.plot(Xi[:, 0], Xi[:, 1], colors[k], markersize=4, alpha=.8)

    plt.axis('equal')
    plt.plot()
    plt.show()


kmeans_display(X, original_label)


def kmean_init_centers(X, k):
    # randomly pick k rows of X as init centers
    return X[np.random.choice(X.shape[0], k, replace=False)]


def kmeans_assign_labels(X, centers):
    # calculate pairwise distances between data and centers
    D = cdist(X, centers)
    # return index of the closest center
    return np.argmin(D, axis=1)


def kmeans_update_centers(X, lables, k):
    centers = np.zeros((K, X.shape[1]))
    for k in range(k):
        # collect all points assigned to the k-th cluster
        Xk = X[lables == k, :]
        # mean
        centers[k, :] = np.mean(Xk, axis=0)
    return centers


def converged(centers, new_centers):
    return set([tuple(a) for a in centers]) == set([tuple(a) for a in new_centers])


def kmeans(X, k):
    _centers = [kmean_init_centers(X, k)]
    _labels = []
    _i = 0
    while True:
        _labels.append(kmeans_assign_labels(X, _centers[-1]))
        new_centers = kmeans_update_centers(X, _labels[-1], k)
        if converged(_centers[-1], new_centers):
            break
        _centers.append(new_centers)
        _i += 1
    return _centers, _labels, _i


(centers, labels, i) = kmeans(X, K)
print('Centers found by our algorithm:')
print(centers[-1])

kmeans_display_center(X, labels[-1], centers[-1])

from sklearn.cluster import KMeans

kmeans = KMeans(n_clusters=K, random_state=0).fit(X)
print('Centers found by sklearn algorithm:')
print(kmeans.cluster_centers_)
labels = kmeans.predict(X)
kmeans_display(X, labels)
