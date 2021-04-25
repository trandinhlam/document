import sys
from sklearn import metrics
from sklearn.cluster import KMeans

def DB(data):
    db_min = sys.float_info.max
    db_min_clusters = 2
    for n_clusters in range(2, 10):
        model = KMeans(n_clusters=n_clusters)
        labels = model.fit_predict(data)
        db_score = metrics.davies_bouldin_score(data, labels)
        if db_score < db_min:
            db_min = db_score
            db_min_clusters = n_clusters
    return db_min_clusters
