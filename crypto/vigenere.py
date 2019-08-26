from helpers import alphabet_position, rotate_character

alpha1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

alpha2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z']


def encrypt(sentence, word):
    idx = 0
    new_sentence = ""
    for letter in sentence:
        if letter in alpha1 or letter in alpha2:
            if idx < len(word):
                rotate = alphabet_position(word[idx])
                nl = rotate_character(letter, rotate)
                new_sentence = new_sentence + nl
                idx = idx + 1
            else:
                idx = 0
                rotate = alphabet_position(word[idx])
                nl = rotate_character(letter,rotate)
                new_sentence = new_sentence + nl
                idx = idx + 1
        else:
            new_sentence = new_sentence + letter

    return new_sentence
            


def main():

    print(encrypt(input("Type a sentence. "), input("Type an encrypting word. ")))

if __name__ == "__main__":
    main()


    
