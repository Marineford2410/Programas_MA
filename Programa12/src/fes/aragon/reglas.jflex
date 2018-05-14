package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
%public
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%%
{WHITE} {/*Ignore*/}
"num" {return NUM;}
"+" {return SUMA;}
"*" {return MULT;}
";" {return PUNTOCOMA;}
"(" {return PARENTIZQ;}
")" {return PARENTDER;}
. {return ERROR;}