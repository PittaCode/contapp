from datetime import datetime
from app import db


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(128), index=True, nullable=False)
    surname = db.Column(db.String(128), index=True, nullable=False)
    alias = db.Column(db.String(128), index=True, unique=True, nullable=False)
    created = db.Column(db.DateTime, default=datetime.utcnow)

    def __repr__(self):
        return f'<User {self.name} {self.surname} AKA {self.alias}>'
