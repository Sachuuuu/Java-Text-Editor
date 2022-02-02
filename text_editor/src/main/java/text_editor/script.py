
import sys
def emoji(val):
    if val == ":-)":
        print("u263A")
    elif val == ":D":  
          print("uD83DuDE00")
    elif val == ":)":
        print("uD83DuDE42")
    elif val == ":p" or val == ":P":
        print("uD83DuDE1B")
if __name__ == '__main__':
    emoji(sys.argv[2])

