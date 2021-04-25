import os
import numpy as np
from sklearn import preprocessing

from lamtd.clusters import num_cluster_chosen
import config
from lamtd.clusters.cvi import fitness_functions
from optimizers import FA, PSO
from lamtd import displayer

###### INIT OPTIMIZER AND DATASET
optimizer = PSO
# optimizer = FA
# dataset_file = 'dataset/iris.csv'
# dataset_file = 'dataset/iris2D.csv'
# dataset_file = 'dataset/flame.csv'
dataset_file = 'dataset/heart.csv'
########### END INIT


# Read the dataset file and generate the points list and true values
rawData = open(os.path.join(os.path.abspath(os.path.dirname(__file__)), dataset_file), 'rt')
data = np.loadtxt(rawData, delimiter=",")
nPoints, nValues = data.shape  # Number of points and Number of values for each point
print(nPoints, nValues)
dimension = nValues - 1  # Dimension value
points = data[:, :-1].tolist()  # list of points
labelsTrue = data[:, -1].tolist()  # List of actual cluster of each points (last field)

points = preprocessing.normalize(points, norm='max', axis=0)
# find best k cluster
k = num_cluster_chosen.DB(points)
if k > 8:
    k = 8
print(k)
solution = optimizer.run(fitness_functions.DB, config.minFitness, config.maxFitness, k * dimension,
                         config.populationSize,
                         config.MaxIt, k,
                         points)
bestSolution = np.reshape(solution.bestIndividual, (k, dimension))

print('best centroid', bestSolution)
print('executed in secords:', solution.executionTime)
print('labelsPreditect: ', solution.labelsPred)

displayer.result_display_center(points, solution.labelsPred, bestSolution)
displayer.display_converge(np.array(solution.convergence))
