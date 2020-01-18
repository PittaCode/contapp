from app import application
from flask import request
from flask import render_template


@application.route('/')
def index():
    return render_template('index.html', token='contapp-token')


@application.route('/hello')
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


@application.route('/test-post', methods=['POST'])
def test_post():
    print(request)
    print(request.form)
    print(request.get_json())

    if request.get_json():
        return request.get_json(), 200
    else:
        return request.form, 200


if __name__ == "__main__":
    application.run()
