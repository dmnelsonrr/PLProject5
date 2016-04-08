tokens = (
    'WINE', 'INTEGER', 'RANK', 'CHATEAU', 'DOMAINE', 'PETRUS', 'DOM', 'OPUS', 'TENUTA',
)

literals = ['.',  ]

t_WINE = r'Wine[ -~]+$'
t_RANK = r'Rank.*'
t_CHATEAU = r'Chateau[ -~]+$'
t_DOMAINE = r'Domaine[ -~]+$'
t_PETRUS = r'Petrus[ -~]+$'
t_DOM = r'Dom[ -~]+$'
t_OPUS = r'Opus[ -~]+$'
t_TENUTA = r'Tenuta[ -~]+$'

def t_newline(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")

t_ignore = ' \r\n'

def t_period(t):
    r'\.'
    t.type = '.'
    return t

def t_INTEGER(t):
    r'\d+'
    try:
        t.value = int(t.value)
    except ValueError:
        print("Integer value too large %d", t.value)
        t.value = 0
    return t

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)
    
import ply.lex as lex
lexer = lex.lex()

def p_start(t):
    ''' start : wine
              | rank
              | empty
              | chateau
              | domaine
              | petrus
              | dom
              | opus
              | tenuta
    '''
def p_rank(t):
    'rank : RANK'
    pass

def p_empty(t):
    'empty : '
    pass

def p_wine(t):
    'wine : INTEGER "." WINE'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_chateau(t):
    'chateau : INTEGER "." CHATEAU'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_domaine(t):
    'domaine : INTEGER "." DOMAINE'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_petrus(t):
    'petrus : INTEGER "." PETRUS'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_dom(t):
    'dom : INTEGER "." DOM'
    print(str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_opus(t):
    'opus : INTEGER "." OPUS'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))

def p_tenuta(t):
    'tenuta : INTEGER "." TENUTA'
    print (str(t[1]) + str(t[2]) + " " + str(t[3]))
    
def p_error(t):
    if t == None:
        print("Syntax error at '%s'" % t)
    else:
        print("Syntax error at '%s'" % t.value)
    
import ply.yacc as yacc
parser = yacc.yacc()

while True:
    try:
        s = input('')
    except EOFError:
        break
    parser.parse(s)

    
