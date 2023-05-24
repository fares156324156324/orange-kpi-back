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
db.createCollection("Projectdb"); //MongoDB creates the database when you first store data in that database