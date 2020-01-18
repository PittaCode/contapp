import os
from config import Config
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

frontend_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..', 'frontend'))
template_folder = os.path.join(frontend_path, 'build')
static_folder = os.path.join(template_folder, 'static')
print(template_folder, static_folder)

application = Flask(__name__, static_folder=static_folder, template_folder=template_folder)
application.config.from_object(Config)

db = SQLAlchemy(application)

migrate = Migrate(application, db)

from app import routes, models  # nopep8
