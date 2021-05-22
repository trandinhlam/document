MERGE (u1:User {id: %s}) MERGE (g:CITY {name:'%s'})  CREATE (u1)-[:IN]->(g)
MERGE (u1:User {id: %s}) MERGE (g:GEN {name:'%s'}) CREATE (u1)-[:BORN]->(g)
MERGE (u1:User {id: %s}) MERGE (u2:User {id:%s})  CREATE (u1)-[:FRIEND]->(u2)  CREATE (u2)-[:FRIEND]->(u1)

MATCH (n:User{id: %s})
MATCH (n)-[:FRIEND * %d]-(m)
MATCH (m)-[:BORN]->(g:GEN{name:'%s'})
MATCH (m)-[:IN]->(c:CITY{name:'%s'})
WHERE NOT (n)-[:FRIEND]-(m)
RETURN DISTINCT m.id