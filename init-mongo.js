db.createUser(
    {
        user: "fares",
        pwd: "fares",
        roles: [
            {
                role: "readWrite",
                db: "OrangeTn"
            }
        ]
    }
);
