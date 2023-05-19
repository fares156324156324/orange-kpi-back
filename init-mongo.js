db.createUser(
    {
        user: "root",
        pwd: "rot",
        roles: [
            {
                role: "readWrite",
                db: "my_db"
            }
        ]
    }
);
db.createCollection("Projectdb"); //MongoDB creates the database when you first store data in that database