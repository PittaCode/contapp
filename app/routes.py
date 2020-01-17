from app import application
from flask import request


@application.route('/query')
def hello():
    if request.args:

        # We have our query string nicely serialized as a Python dictionary
        args = request.args

        # We'll create a string to display the parameters & values (???)
        serialized = ", ".join(f"{k}: {v}" for k, v in args.items())

        # Display the query string to the client in a different format
        return f"Hello {serialized}", 200

    else:

        return "No query string received", 200


if __name__ == "__main__":
    application.run()
