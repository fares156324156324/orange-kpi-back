db.createUser(
    {
        user: "fares",
        pwd: "fares",
        roles: [
            {
                role: "readWrite",
                db: "fares"
            }
        ]
    }
);
db.createCollection("Projectdb"); 