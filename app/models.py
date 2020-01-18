from app import db


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(128), index=True)
    surname = db.Column(db.String(128), index=True)
    alias = db.Column(db.String(128), index=True, unique=True)

    def __repr__(self):
        return f'<User {self.name} {self.surname} AKA {self.alias}>'
