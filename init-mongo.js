db.createUser(
    {
        user: "fares",
        pwd: "fares",
        roles: [
            {
                role: "readWrite",
                db: "admin"
            }
        ]
    }
);
db.createCollection("Projectdb"); 