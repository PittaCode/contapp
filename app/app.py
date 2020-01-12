import os
from flask import Flask
from flask import request

application = Flask(__name__)

@app.route('/query')
def hello():
    if request.args:
    
        # We have our query string nicely serialized as a Python dictionary
        args = request.args

        # We'll create a string to display the parameters & values (???)
        serialized = ", ".join(f"{k}: {v}" for k, v in request.args.items())

        # Display the query string to the client in a different format
        return f"Hello {serialized}", 200

    else:

        return "No query string received", 200 
