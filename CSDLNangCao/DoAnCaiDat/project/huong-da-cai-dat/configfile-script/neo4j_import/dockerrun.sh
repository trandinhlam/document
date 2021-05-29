docker run -it -p 7687:7687 -p 7474:7474 -v $PWD:/import neo4j

neo4j-admin load --from=/import/neo4j_social_network.dump