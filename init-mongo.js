db = db.getSiblingDB('Projectdb');
db.createUser({
  user: 'fares',
  pwd: 'password',
  roles: [{ role: 'readWrite', db: 'Projectdb' }]
});
