import os
from flask import Flask

application = Flask(__name__)


@application.route('/hello')
def hello():
    return 'Hello Eleni'


if __name__ == "__main__":
    application.run()
