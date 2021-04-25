import numpy as np
import matplotlib.pyplot as plt


def result_display_center(X, label, centers):
    K = np.amax(label) + 1
    colors = np.array(['b^', 'go', 'rs', 'yo', 'm^', 'c^', 'y^', 'k^']).T
    for k in range(0, K):
        Xi = X[label == k, :]
        plt.plot(Xi[:, 0], Xi[:, 1], colors[k], markersize=4, alpha=.8)
        plt.plot(centers[k, 0], centers[k, 1], colors[k], markersize=10, alpha=.8)

    plt.axis('equal')
    plt.plot()
    plt.show()


def display_converge(convergence, label='cvi_name'):
    plt.ioff()
    iters = range(convergence.shape[0])
    plt.plot(iters, convergence, label=label)
    plt.xlabel('Iterations')
    plt.ylabel('Fitness')
    plt.legend(loc="upper right", bbox_to_anchor=(1.2, 1.02))
    plt.grid()
    plt.show()
