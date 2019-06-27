from flask import Flask, request, redirect, render_template

app = Flask(__name__)
app.config['DEBUG'] = True


@app.route('/validate_signup')
def display_user_form():
    return render_template('index.html')

@app.route('/validate_signup', methods=['POST'])
def validate_username():

    username = request.form['username']
    password = request.form['password']
    verify = request.form['verify']
    email = request.form['email']

    username_error = ''
    password_error = ''
    verify_error = ''
    email_error =''

    if username == '':
        username_error = 'Please enter a username'
        verify=''
        password=''

    elif len(username) < 3 or len(username) > 20:
            username_error = 'Please submit a username between 3 and 20 characters.'
            verify=''
            password=''

    else:
        for letter in username:
            if letter ==" ":
                username_error = 'Please use a valid character in your username. Spaces are not allowed.'
                verify=''
                password=''
        

    if password == '':
        password_error = 'Please enter a password'
        password=''
        verify=''

    elif len(password) < 3 or len(password) > 20:
            password_error = 'Please submit a password between 3 and 20 characters.'
            password=''
            verify=''

    else:
        for letter in password:
            if letter ==" ":
                password_error = 'Please use a valid character in your password. Spaces are not allowed.'
                password=''
                verify=''

    if verify == '':
        verify_error = 'Please enter a password to verify'
        verify=''
        password=''
    else:
        if password != verify:
            verify_error = 'Passwords do not match.'
            verify=''
            password=''

    counta = 0
    for letter in email:
        if letter == "@":
            counta = 1 + counta
    if counta > 1:
        email_error = "Please submit a valid email."

    countp = 0
    for letter in email:
        if letter == ".":
            countp = 1 + countp
    if countp > 1:
        email_error = "Please submit a valid email."

    if len(email) < 3 or len(email) > 20:
            email_error = 'Please submit an email between 3 and 20 characters.'
    if len(email) == 0:
            email_error =''
            

    if not username_error and not password_error and not verify_error:
        name = username
        return redirect('/valid_submission?name={0}'.format(name))
    else:
        return render_template('index.html', username_error=username_error, password_error=password_error, verify_error=verify_error, email_error=email_error, username=username, password=password, verify=verify, email=email)
        


@app.route('/valid_submission')
def valid_submission():
    name = request.args.get('name')
    return render_template('welcome.html', name = name)
    

    





app.run()

