from helpers import alphabet_position, rotate_character
alpha1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

alpha2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z']


def encrypt(text, rot):

    new_string = ""
    for char in text:
        new_l = rotate_character(char, rot)
        new_string = new_string + new_l
    return new_string

def main():
    print(encrypt((input("Text to encrypt? ")), (input("Number of rotations? "))))

if __name__ == "__main__":
    main()


