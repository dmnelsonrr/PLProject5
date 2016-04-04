import ply.lex as lex

tokens = (
    'NUMBER', 'PLUS', 'MINUS', 'TIMES', 'DIVIDE', 'EQUAL', 'ID', 
)


def t_NUMBER(t):
    r'\d+'
    t.value = int(t.value)
    return t

def t_PLUS(t):
    r'\+'
    t.value = str(t.value)
    return t

def t_MINUS(t):
    r'\-'
    t.value = str(t.value)
    return t

def t_TIMES(t):
    r'\*'
    t.value = str(t.value)
    return t

def t_DIVIDE(t):
    r'/'
    t.value = str(t.value)
    return t

def t_EQUAL(t):
    r'\='
    t.value = str(t.value)
    return t

def t_ID(t):
    r'([_AA-Za-z])'
    t.value = str(t.value)
    return t


def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)


t_ignore = ' \t'

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

lexer = lex.lex()

#Test

data = open('fileinput.txt', 'r')

lexer.input(data.read())

while True:
    tok = lexer.token()
    if not tok:
        break
    print(tok)
