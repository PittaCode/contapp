import os
basedir = os.path.abspath(os.path.dirname(__file__))


class Config(object):
    SQLALCHEMY_DATABASE_URI = os.environ.get('CONTAPP_DB_URI') or f"sqlite:///{os.path.join(basedir, 'contapp.db')}"
    SQLALCHEMY_TRACK_MODIFICATIONS = False
