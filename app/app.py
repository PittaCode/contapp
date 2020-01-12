import os
from flask import Flask
from flask import request

application = Flask(__name__)


@application.route('/query')
def hello():
    if request.args:
        args = request.args
        user = args['username']
        return f"Hello {user}", 200
   
    else:
        return "No query string received", 200


if __name__ == "__main__":
    application.run()
