alpha1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

alpha2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z']

def alphabet_position(letter): 
    if letter in alpha1:
        letter_ord = alpha1.index(letter) 
    elif letter in alpha2:
        letter_ord = alpha2.index(letter)  
    else:
        return letter
    return letter_ord

def rotate_character(char,rot):
    if char in alpha1:
        char_idx = alphabet_position(char)
        new_pos = (char_idx + int(rot))%26
        new_letter = alpha1[new_pos]
    elif char in alpha2:
        char_idx = alphabet_position(char)
        new_pos = (char_idx + int(rot))%26
        new_letter = alpha2[new_pos]

    else:
        return char
    return new_letter