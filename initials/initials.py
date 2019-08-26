

def get_initials(fullname):
    """ Given a person's name, returns the person's initials (uppercase)"""
    
    lista = fullname.split(" ")
    initials = ""
    
    for name in lista:
        initial = name[0]

        if initial.islower() == True:
            initial = initial.upper()

        initials = initials + initial

    return initials

def main():
    fullname = input("What is your full name?")

    print(get_initials(fullname))

if __name__ == '__main__':
    main()





